package com.schibsted.domain.weapon;

public class Weapon {

    private final String name;
    private final int attack;
    private final int value;

    public Weapon(String name, int attack, int value) {
        this.name = name;
        this.attack = attack;
        this.value = value;
    }

    public String toString(){
        return String.format("*** %s, +%d atk, %dG\n", name, attack, value);
    }
}
