package com.schibsted.application;

import com.schibsted.domain.map.model.Map;

public class ApplicationService {

    private final Map map;

    public ApplicationService(Map map) {
        this.map = map;
    }

    public void movePlayerLeft() {
        map.movePlayerLeft();
    }

    public void movePlayerRight() {
        map.movePlayerRight();
    }

    public void movePlayerUp() {
        map.movePlayerUp();
    }

    public void movePlayerDown() {
        map.movePlayerDown();
    }

    public Map getMap() {
        return map;
    }
}
