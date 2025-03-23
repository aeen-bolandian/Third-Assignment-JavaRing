package org.project.object.consumables;

import org.project.entity.Entity;

// TODO: UPDATE IMPLEMENTATION
public class Flask extends Consumable {
    public Flask(int usageTime, int manaCost) {
        super(usageTime, manaCost);
    }
    /*
    THIS IS AN EXAMPLE OF A CONSUMABLE DESIGN.
    */

    // TODO: (BONUS) UPDATE USE METHOD
    // flask is usable for all players to heal themselves but just some special characters has got healing power
    @Override
    public void use(Entity target) {
        if(getUsageTime() > 0 && target.getMp() >= getManaCost()) {
            target.setHp(target.getMaxHp());
            System.out.println(target.getName() + " is healing using Flask");
        }
        else if(getUsageTime() <= 0) {
            System.out.println("Flask has been used :(");
        }
        else if(target.getMp() < getManaCost()) {
            System.out.println("not enough mana :(");
        }
    }
}
