package com.schibsted.domain.player;

public class Player {
    private final String name;
    private int hitPoints = 10;
    private int attackPoints = 2;
    private int defensePoints = 2;
    private int level = 1;
    private int experience = 0;
    private int gold = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void addExperience(int experience) {
        this.experience += experience;
        double experienceNeededToChenge = experienceNeededToChangeToUpperLevel(level + 1);
        while (experience > experienceNeededToChenge) {
            level++;
            computeLevel(level);
            experienceNeededToChenge = experienceNeededToChangeToUpperLevel(level + 1);
        }
    }

    private void computeLevel(int level) {
        updateAttackPoints(level);
        updateDefensePoints(level);
        updateHitPoints(level);
    }

    private void updateHitPoints(int level) {
        hitPoints = 10 + ((level -1) * 2);
    }

    private void updateDefensePoints(int level) {
        defensePoints = 2 + (int) Math.floor(level / 2);
    }

    private void updateAttackPoints(int level) {
        attackPoints = 2 + (int) Math.floor(level / 3);
    }

    private double experienceNeededToChangeToUpperLevel(int level) {
        return Math.abs((50f / 3f) * (Math.pow(level , 3) - (Math.pow(level , 2) * 6) + (17 * level) - 12));
    }
}
