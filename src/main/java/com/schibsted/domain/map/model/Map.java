package com.schibsted.domain.map.model;

public class Map {

    private final Position UPPER_LEFT_BOUND = new Position(0, 0);
    private final Position LOWER_RIGHT_BOUND = new Position(7, 7);

    public final Position initialPosition = new Position(3, 3);

    private Position playerPosition;

    public Map() {
        this.playerPosition = initialPosition;
    }

    public Position movePlayerLeft() {
        if(playerPosition.getX() > UPPER_LEFT_BOUND.getX())
            playerPosition = playerPosition.left();
        return playerPosition;
    }

    public Position movePlayerRight() {
        if(playerPosition.getX() < LOWER_RIGHT_BOUND.getX())
            playerPosition = playerPosition.right();
        return playerPosition;
    }

    public Position movePlayerUp() {
        if(playerPosition.getY() > UPPER_LEFT_BOUND.getY())
            playerPosition = playerPosition.up();
        return playerPosition;
    }

    public Position movePlayerDown() {
        if(playerPosition.getY() < LOWER_RIGHT_BOUND.getY())
            playerPosition = playerPosition.down();
        return playerPosition;
    }
}
