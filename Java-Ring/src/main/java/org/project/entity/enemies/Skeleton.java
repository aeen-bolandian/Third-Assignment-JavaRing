package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public class Skeleton extends Enemy{
    public Skeleton(int hp, int mp, Weapon weapon) {
        super(hp, mp, weapon);
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
    public int getMaxHP() {
        return 0;
    }

    @Override
    public int getMaxMP() {
        return 0;
    }
    // TODO: DESIGN ENEMY'S WEAPON AND ARMOR AND IMPLEMENT THE CONSTRUCTOR
}
