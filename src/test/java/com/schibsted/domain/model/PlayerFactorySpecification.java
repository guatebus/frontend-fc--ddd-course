package com.schibsted.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerFactorySpecification {

    @Test
    public void createPlayer(){
        PlayerFactory factory = new PlayerFactory();
        Player player = factory.create("A_Player");
        assertEquals(player.getName(),"A_Player");
    }
}
