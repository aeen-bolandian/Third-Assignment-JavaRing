package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public class Skeleton extends Enemy{
    public Skeleton(int hp, int mp, Weapon weapon) {
        super(hp, mp, weapon);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void attack(Entity target) {

    }

    @Override
    public void defend() {

    }

    @Override
    public void heal(int health) {

    }

    @Override
    public void fillMana(int mana) {

    }

    @Override
    public int getMaxHp() {
        return 0;
    }

    @Override
    public int getMaxMp() {
        return 0;
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void setMp(int mp) {

    }

    @Override
    public void setHp(int hp) {

    }
    // TODO: DESIGN ENEMY'S WEAPON AND ARMOR AND IMPLEMENT THE CONSTRUCTOR
}
