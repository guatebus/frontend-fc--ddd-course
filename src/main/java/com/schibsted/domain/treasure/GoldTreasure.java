package com.schibsted.domain.treasure;

import com.schibsted.domain.player.Player;

public class GoldTreasure extends Treasure {

    private final int gold;

    public GoldTreasure(int id, int gold) {
        super(id, Type.ZERO);
        this.gold = gold;
    }

    public int getId() {
        return id;
    }

    @Override
    protected void executeReward(Player player) {
        player.addGold(gold);
    }
}
