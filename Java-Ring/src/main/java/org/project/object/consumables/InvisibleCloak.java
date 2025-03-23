package org.project.object.consumables;

import org.project.entity.Entity;
import org.project.entity.players.Assassin;

public class InvisibleCloak extends Consumable {
    public InvisibleCloak(int usageTime, int manaCost) {
        super(usageTime, manaCost);
    }

    @Override
    public void use(Entity target) {
        if(target instanceof Assassin assassin && getUsageTime() > 0 && target.getMp() >= getManaCost()) {
            assassin.setInvisible(true);
            target.fillMana(-getManaCost());
        }
        else if(getUsageTime() <= 0) {
            System.out.println("can not use invisibility device");
        }
        else if(target.getMp() < getManaCost()) {
            System.out.println("do not have enough mana to use invisibility device");
        }
    }
}
