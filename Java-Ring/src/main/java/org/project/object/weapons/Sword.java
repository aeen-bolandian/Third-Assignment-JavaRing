package org.project.object.weapons;

import org.project.entity.Entity;

import java.util.ArrayList;

// TODO: UPDATE IMPLEMENTATION
public class Sword extends Weapon{
    /*
    THIS IS AN EXAMPLE OF A WEAPON DESIGN.
    */

    public Sword(int damage, int manaCost) {
        super(damage, manaCost);
    }

    public void use(Entity target) {
        checkBroke();
        if(!isBroke()) {
            target.takeDamage(getDamage());
            setDamage(getDamage() - 1);
        }
        else {
            System.out.println("Sword has been broken");
            System.out.println("repairing sword ... ");
            repair(target);
        }
    }
    // TODO: (BONUS) UPDATE THE UNIQUE ABILITY
    public void uniqueAbility(ArrayList<Entity> targets , Entity player) {
        checkBroke();
        if(!isBroke() && getDamage() > targets.size() / 2 && player.getMp() >= targets.size() * 5) {
            for (Entity target : targets) {
                target.takeDamage(getDamage());
                player.fillMana(-5);
            }
            setDamage(getDamage() - (targets.size()) / 2);
            System.out.println(player.getName() + " is launching a super attack!");
            return;
        }
        else if(isBroke()) {
            System.out.println("Sword has been broken");
        }
        else if(getDamage() <= targets.size()) {
            System.out.println("Sword hasn't got enough damage for all enemies :(");
        }
        else if(player.getMp() < targets.size() * 5) {
            System.out.println("hasn't got enough mana for a super attack :(");
        }
        System.out.println("super attack failed :(");
    }
}
