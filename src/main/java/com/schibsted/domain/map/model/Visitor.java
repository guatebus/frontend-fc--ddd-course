package com.schibsted.domain.map.model;

public interface Visitor {

    enum Type {CLOSED_TREASURE, OPEN_TREASURE, SHOP}

    VisitorReference getReference(Position position);
}
