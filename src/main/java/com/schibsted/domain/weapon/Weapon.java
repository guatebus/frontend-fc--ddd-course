package com.schibsted.domain.weapon;

public class Weapon {

    private final String name;
    private final int attack;
    private final int value;
    private final int id;

    public Weapon(int id, String name, int attack, int value) {
        this.id = id;
        this.name = name;
        this.attack = attack;
        this.value = value;
    }

    public int getId(){
        return id;
    }

    public int getPrice() {
        return value;
    }

    public int getAttack() {
        return attack;
    }

    public String toString(){
        return String.format(" %d) %s, +%d atk, %dG\n", id, name, attack, value);
    }

}
