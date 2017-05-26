package com.schibsted.domain.map.model;

import com.schibsted.domain.player.model.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Map {

    public final Position initialPosition = new Position(3, 3);

    private Position playerPosition;

    public Map() {
        this.playerPosition = initialPosition;
    }

    public Position movePlayerLeft() {
        playerPosition = playerPosition.left();
        return playerPosition;
    }

    public Position movePlayerRight() {
        playerPosition = playerPosition.rigth();
        return playerPosition;
    }

    public Position movePlayerUp() {
        playerPosition = playerPosition.up();
        return playerPosition;
    }

    public Position movePlayerDown() {
        playerPosition = playerPosition.down();
        return playerPosition;
    }
}
