package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.model.Player;

public class GoldTreasure implements Treasure {
    private final int gold;

    public GoldTreasure(int gold) {
        this.gold = gold;
    }

    @Override
    public EmptyTreasure open(Player opener) {
        opener.addGold(gold);
        return new EmptyTreasure();
    }

    @Override
    public VisitorReference getReference(int x, int y) {
        return new VisitorReference(x, y, 0, 0);
    }
}
