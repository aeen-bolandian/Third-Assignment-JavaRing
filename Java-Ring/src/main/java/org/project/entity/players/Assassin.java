package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public class Assassin extends Player {

    // is isInvisible is true enemy can not attack
    private boolean isInvisible;
    private int defense;

    public Assassin(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
        isInvisible = false;
        defense = 7;
    }
    public boolean isInvisible() { return isInvisible; }
    public void setInvisible(boolean invisible) { isInvisible = invisible; }

    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

    public void attack(Entity target) {
        if(isInvisible) {
            target.takeDamage(weapon.getDamage() + 10);
        }
        else {
            weapon.use(target);
        }
    }

    public void takeDamage(int damage) {
        if(isInvisible) {
            setHp(getHp());
            System.out.println("can not recognize " + getName());
        }
        else {
            setHp(getHp() - damage + defense);
        }
    }

    @Override
    public void heal() {
        if(getMp() > (getMaxHp() - getHp())) {
            setHp(getMaxHp());
            fillMana(-(getMaxHp() - getHp()));
        }
    }
}
