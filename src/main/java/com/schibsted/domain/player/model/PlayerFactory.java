package com.schibsted.domain.player.model;

public class PlayerFactory {
    public Player create(String playerName) {
        return new Player(playerName);
    }
}
