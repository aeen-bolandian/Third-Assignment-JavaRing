package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

// goblin can steal your mana! so kill them as fast as you can and watch out!
public class Goblin extends Enemy{

    private int stolenMana;

    public Goblin(String name, int hp, int mp, Weapon weapon) {
        super(name, hp, mp, weapon);
        stolenMana = 0;
    }

    public void stealMana(Entity target) {
        stolenMana += 1;
        target.fillMana(-1);
    }

    public int getStolenMana() { return stolenMana; }
    public void setStolenMana(int stolenMana) { this.stolenMana = stolenMana; }
}
