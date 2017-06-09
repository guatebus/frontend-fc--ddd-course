package com.schibsted.domain.treasure;

import com.schibsted.domain.player.Player;

public class TreasureService {
    private final TreasureRepository repository;

    public TreasureService(TreasureRepository repository) {
        this.repository = repository;
    }

    public Treasure openTreasure(int id, Player player) {
        Treasure treasure = repository.get(id);
        treasure = treasure.open(player);
        return repository.save(treasure);
    }
}
