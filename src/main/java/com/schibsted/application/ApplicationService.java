package com.schibsted.application;

import com.schibsted.domain.map.model.Map;

public class ApplicationService {

    public void movePlayerLeft(Map map) {
        map.movePlayerLeft();
    }

    public void movePlayerRight(Map map) {
        map.movePlayerRight();
    }

    public void movePlayerUp(Map map) {
        map.movePlayerUp();
    }

    public void movePlayerDown(Map map) {
        map.movePlayerDown();
    }
}
