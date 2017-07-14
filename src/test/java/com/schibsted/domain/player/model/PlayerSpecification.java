package com.schibsted.domain.player.model;

import com.schibsted.domain.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerSpecification {

    public Player player;

    @Before
    public void init() {
        player = new Player("A_Player");
    }

    @Test
    public void should_have_initial_attributes() throws Exception {
        assertEquals(player.getName(), "A_Player");
        assertEquals(player.getHitPoints(), 10);
        assertEquals(player.getAttackPoints(), 2);
        assertEquals(player.getDefensePoints(), 2);
        assertEquals(player.getLevel(), 1);
        assertEquals(player.getExperience(), 0);
        assertEquals(player.getGold(), 0);
    }

    @Test
    public void should_add_experience() throws Exception {
        player.addExperience(100);

        assertEquals(player.getExperience(), 100);
    }

    @Test
    public void should_level_up_to_two() throws Exception {
        player.addExperience(100);

        assertEquals(2, player.getLevel());
        assertEquals(2, player.getAttackPoints());
        assertEquals(3, player.getDefensePoints());
        assertEquals(12, player.getHitPoints());
    }

    @Test
    public void should_level_up_to_three() throws Exception {
        player.addExperience(200);

        assertEquals(3, player.getLevel());
        assertEquals(3, player.getAttackPoints());
        assertEquals(3, player.getDefensePoints());
        assertEquals(14, player.getHitPoints());

    }
}