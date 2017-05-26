package com.schibsted.domain.map.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MapSpecification {

    private Map map;

    @Before
    public void setUp() throws Exception {
        map = new Map();
    }

    @Test
    public void should_move_player_left() throws Exception {
        Position finalPosition = map.movePlayerLeft();

        Assert.assertEquals(finalPosition, map.initialPosition.left());
    }

    @Test
    public void should_move_player_right() throws Exception {
        Position finalPosition = map.movePlayerRight();

        Assert.assertEquals(finalPosition, map.initialPosition.rigth());
    }

    @Test
    public void should_move_player_up() throws Exception {
        Position finalPosition = map.movePlayerUp();

        Assert.assertEquals(finalPosition, map.initialPosition.up());
    }

    @Test
    public void should_move_player_down() throws Exception {
        Position finalPosition = map.movePlayerDown();

        Assert.assertEquals(finalPosition, map.initialPosition.down());
    }
}
