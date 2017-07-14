package com.schibsted.domain.shop;

import com.schibsted.domain.map.model.Position;
import com.schibsted.domain.map.model.Visitor;
import com.schibsted.domain.map.model.VisitorReference;

public class Shop implements Visitor {
    private final int id;

    public Shop(int id) {
        this.id = id;
    }

    @Override
    public VisitorReference getReference(Position position) {
        return new VisitorReference(position, id, Type.SHOP.ordinal());
    }
}
