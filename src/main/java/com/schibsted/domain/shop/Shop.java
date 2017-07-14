package com.schibsted.domain.shop;

import com.schibsted.domain.map.model.Position;
import com.schibsted.domain.map.model.Visitor;
import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shop implements Visitor {
    private final int id;

    private List<Weapon> items = new ArrayList<>();

    public Shop(int id) {
        this.id = id;
        items.add(new Weapon("Short Sword", 1, 100));
        items.add(new Weapon("Sabre", 3, 500));
        items.add(new Weapon("Long Sword", 6, 1200));
        items.add(new Weapon("Katana", 5, 1000));
        items.add(new Weapon("MasterSword", 10, 1800));
        items.add(new Weapon("Monster BAZOOKA", 50, 1));
    }

    @Override
    public VisitorReference getReference(Position position) {
        return new VisitorReference(position, id, Type.SHOP.ordinal());
    }

    public String getShoppingList() {
        return items.stream().map(it -> it.toString()).reduce("", String::concat);
    }
}
