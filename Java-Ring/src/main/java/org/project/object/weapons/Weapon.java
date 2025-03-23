package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.object.Object;

// TODO: UPDATE IMPLEMENTATION
public abstract class Weapon implements Object {
    private int damage;
    private final int maxDamage;
    private final int manaCost;
    private boolean isBroke;

    /*
    TODO: ADD OTHER REQUIRED AND BONUS ATTRIBUTES
    */

    public Weapon(int maxDamage, int manaCost) {
        this.damage = maxDamage;
        this.maxDamage = maxDamage;
        this.manaCost = manaCost;
        this.isBroke = false;
    }

    @Override
    public void use(Entity target) {
        target.takeDamage(damage);
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {this.damage = damage;}

    public int getManaCost() {
        return manaCost;
    }

    public boolean isBroke(){ return isBroke; }
    public void checkBroke() {
        isBroke = damage <= 0;
    }

    public void repair(Entity target) {
        if (target.getMp() >= manaCost) {
            System.out.println(" has been repaired successfully");
            damage = maxDamage;
            isBroke = false;
            target.fillMana(-manaCost);
        }
        else
            System.out.println("not enough mana to repair");
    }

    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */
}
