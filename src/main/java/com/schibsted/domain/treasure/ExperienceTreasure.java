package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.Position;
import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.Player;

public class ExperienceTreasure implements Treasure {

    private final int id;
    private final int experience;

    public ExperienceTreasure(int id, int experience) {
        this.id = id;
        this.experience = experience;
    }

    @Override
    public VisitorReference getReference(Position position) {
        return new VisitorReference(position, id, 0);
    }

    @Override
    public Treasure open(int dice, Player opener) {
        if (dice > 10) {
            opener.addExperience(experience);
        }
        if (dice > 80) {
            return this;
        }
        return new EmptyTreasure(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperienceTreasure)) return false;

        ExperienceTreasure that = (ExperienceTreasure) o;

        if (id != that.id) return false;
        return experience == that.experience;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + experience;
        return result;
    }

    public int getId() {
        return id;
    }
}
