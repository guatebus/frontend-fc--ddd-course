package com.schibsted.domain.treasure;

import com.schibsted.domain.player.Player;

public class TreasureService {
    private Treasure treasure;

    public TreasureService(Treasure treasure) {
        this.treasure = treasure;
    }

    public Treasure openTreasure(Player player) {
        treasure = treasure.open(player);
        return treasure;
    }
}
