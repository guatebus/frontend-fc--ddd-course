package com.schibsted.domain.treasure;

import com.schibsted.domain.player.Player;

public class EmptyTreasure extends Treasure {

    public EmptyTreasure(int id) {
        super(id, Type.OPEN_TREASURE);
    }

    public int getId() {
        return id;
    }

    @Override
    protected void executeReward(Player player) {

    }
}
