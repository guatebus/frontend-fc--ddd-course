package com.schibsted.domain.treasure;

import com.schibsted.domain.player.model.Player;

public class TreasureService {
    private Treasure treasure = new GoldTreasure(250);

    public Treasure openTreasure(Player player) {
        treasure = treasure.open(player);
        return treasure;
    }
}
