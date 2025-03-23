package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.armors.KnightArmor;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public class Knight extends Player {

    private int defense;
    public Knight(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
        defense = 10;
    }

    public void attack(Entity target) {
        weapon.use(target);
    }

    public void defend(Entity target) {
        armor.use(target);
    }

    public void takeDamage(int damage) {
        setHp(getHp() - damage + defense);
    }

    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

    @Override
    public void heal() {
        if(getMp() > (getMaxHp() - getHp())) {
            setHp(getMaxHp());
            fillMana(-(getMaxHp() - getHp()));
        }
    }
    // TODO: DESIGN KNIGHT'S WEAPON AND ARMOR AND IMPLEMENT THE CONSTRUCTOR
}
