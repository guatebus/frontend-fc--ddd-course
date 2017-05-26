package com.schibsted.domain.model;

public class PlayerFactory {
    public Player create(String playerName) {
        return new Player(playerName);
    }
}
