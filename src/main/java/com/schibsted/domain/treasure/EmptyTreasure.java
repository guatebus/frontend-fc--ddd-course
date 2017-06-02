package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.model.Player;

public class EmptyTreasure implements Treasure {
    @Override
    public EmptyTreasure open(Player opener) {
        return this;
    }

    @Override
    public VisitorReference getReference(int x, int y) {
        return new VisitorReference(x, y, 1, 1);
    }
}
