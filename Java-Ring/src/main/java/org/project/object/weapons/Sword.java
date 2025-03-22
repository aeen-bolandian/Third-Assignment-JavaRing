package org.project.object.weapons;

import org.project.entity.Entity;

import java.util.ArrayList;

// TODO: UPDATE IMPLEMENTATION
public class Sword extends Weapon{
    /*
    THIS IS AN EXAMPLE OF A WEAPON DESIGN.
    */

    int abilityCharge;

    public Sword(int damage, int manaCost) {
        super(damage, manaCost);
    }

    // TODO: (BONUS) UPDATE THE UNIQUE ABILITY
    public void uniqueAbility(ArrayList<Entity> targets) {
        abilityCharge += 2;
        for (Entity target : targets) {
            target.takeDamage(getDamage());
        }
    }
}
