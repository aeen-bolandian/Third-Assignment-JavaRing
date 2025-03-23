package org.project.object.consumables;

import org.project.entity.Entity;

import java.util.ArrayList;

public class Spell extends Consumable {
    public Spell(int usageTime, int manaCost) {
        super(usageTime, manaCost);
    }


    public void SpellUse(Entity player , ArrayList<Entity> targets) {
        if (getUsageTime() > 0 && player.getMp() > getManaCost()) {
            for(Entity target : targets) {
                target.takeDamage(5);
            }
            player.setHp(player.getHp() + targets.size() * 5);
            player.fillMana(-40);
        }
    }


}
