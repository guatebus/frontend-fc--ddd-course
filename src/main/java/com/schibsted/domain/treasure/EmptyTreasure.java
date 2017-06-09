package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.Position;
import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.Player;

public class EmptyTreasure implements Treasure {

    private final int id;

    public EmptyTreasure(int id) {
        this.id = id;
    }

    @Override
    public Treasure open(int dice, Player opener) {
        return this;
    }

    @Override
    public VisitorReference getReference(Position position) {
        return new VisitorReference(position, id, 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmptyTreasure)) return false;

        EmptyTreasure that = (EmptyTreasure) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }
}
