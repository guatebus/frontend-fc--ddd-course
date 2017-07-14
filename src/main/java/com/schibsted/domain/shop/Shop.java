package com.schibsted.domain.shop;

import com.schibsted.domain.map.model.Position;
import com.schibsted.domain.map.model.Visitor;
import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.Player;
import com.schibsted.domain.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shop implements Visitor {
    private final int id;

    private List<Weapon> weapons = new ArrayList<>();

    public Shop(int id) {
        this.id = id;
        weapons.add(new Weapon(1, "Short Sword", 1, 100));
        weapons.add(new Weapon(2, "Sabre", 3, 500));
        weapons.add(new Weapon(3, "Long Sword", 6, 1200));
        weapons.add(new Weapon(4, "Katana", 5, 1000));
        weapons.add(new Weapon(5, "MasterSword", 10, 1800));
        weapons.add(new Weapon(6, "Monster BAZOOKA", 50, 0));
    }

    @Override
    public VisitorReference getReference(Position position) {
        return new VisitorReference(position, id, Type.SHOP.ordinal());
    }

    public String showItemListFor(Player player) {
        return weapons.stream().map(it -> player.getWeapons().stream().filter(pwid -> pwid == it.getId()).collect(Collectors.toList()).size() > 0 ? "***" + it.toString() : it.toString() ).reduce("", String::concat);
    }

    public Player performPurchase(Player player, String command) {
        try {
            int toPurchase = Integer.valueOf(command);
            Weapon weaponToPurchase = weapons.stream().filter(it -> it.getId() == toPurchase).findFirst().get();
            if (weaponToPurchase.getPrice() <= player.getGold()) {
                player.subtractGold(weaponToPurchase.getPrice());
                player.addAttackPoints(weaponToPurchase.getAttack());
                player.addWeapon(weaponToPurchase.getId());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return player;
    }
}
