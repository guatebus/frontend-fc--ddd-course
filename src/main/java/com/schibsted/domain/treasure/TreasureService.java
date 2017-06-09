package com.schibsted.domain.treasure;

import com.schibsted.domain.player.Player;

public class TreasureService {
    private final TreasureRepository repository;
    private final RollDice rollDice;

    public TreasureService(RollDice rollDice, TreasureRepository repository) {
        this.repository = repository;
        this.rollDice = rollDice;
    }

    public Treasure openTreasure(int id, Player player) {
        Treasure treasure = repository.get(id);
        treasure = treasure.open(rollDice.roll(), player);
        return repository.save(treasure);
    }
}
