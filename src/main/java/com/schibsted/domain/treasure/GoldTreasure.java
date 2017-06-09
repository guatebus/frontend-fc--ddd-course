package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.Position;
import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.Player;

public class GoldTreasure implements Treasure {
    private final int id;
    private final int gold;

    public GoldTreasure(int id, int gold) {
        this.id = id;
        this.gold = gold;
    }

    @Override
    public EmptyTreasure open(Player opener) {
        opener.addGold(gold);
        return new EmptyTreasure(id);
    }

    @Override
    public VisitorReference getReference(Position position) {
        return new VisitorReference(position, id, 0);
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoldTreasure)) return false;

        GoldTreasure that = (GoldTreasure) o;

        if (id != that.id) return false;
        return gold == that.gold;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + gold;
        return result;
    }
}
