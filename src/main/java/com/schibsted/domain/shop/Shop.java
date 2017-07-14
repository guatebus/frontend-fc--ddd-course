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

    public String getShoppingList() {
        return "*** Short Sword, +1 atk, 100G\n" +
                "*** Sabre, +3 atk, 500G\n" +
                "*** Long Sword, +6 atk, 1200G\n" +
                "*** Katana, +5 atk, 1000G\n" +
                "*** Master Sword, +10 atk, 1800G\n";
    }
}
