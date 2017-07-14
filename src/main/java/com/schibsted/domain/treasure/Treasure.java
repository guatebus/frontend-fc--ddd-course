package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.Position;
import com.schibsted.domain.map.model.Visitor;
import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.Player;

public abstract class Treasure implements Visitor {

    public enum Type {ZERO, ONE}

    final int id;
    private final Type type;

    protected Treasure(int id, Type type) {
        this.id = id;
        this.type = type;
    }

    protected abstract void executeReward(Player player);

    final Treasure open(int dice, Player opener) {
        if (dice > 10) {
            executeReward(opener);
        }
        if (dice > 80) {
            return this;
        }
        return new EmptyTreasure(id);
    }

    @Override
    public final VisitorReference getReference(Position position) {
        return new VisitorReference(position, id, type.ordinal());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Treasure)) return false;

        Treasure treasure = (Treasure) o;

        return id == treasure.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
