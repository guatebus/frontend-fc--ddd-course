package com.schibsted.domain.map.model;

public interface Visitor {
    VisitorReference getReference(int x, int y);
}
