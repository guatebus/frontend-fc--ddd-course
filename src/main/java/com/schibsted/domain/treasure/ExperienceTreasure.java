package com.schibsted.domain.treasure;

import com.schibsted.domain.player.Player;

public class ExperienceTreasure extends Treasure {

    private final int experience;

    public ExperienceTreasure(int id, int experience) {
        super(id, Type.CLOSED_TREASURE);
        this.experience = experience;
    }

    @Override
    protected void executeReward(Player player) {
        player.addExperience(experience);
    }

    public int getId() {
        return id;
    }

}
