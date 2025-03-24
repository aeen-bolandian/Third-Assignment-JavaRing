package org.project.object.consumables;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;

import java.util.ArrayList;

public class Spell extends Consumable {
    public Spell(int usageTime, int manaCost) {
        super(usageTime, manaCost);
    }


    public void SpellUse(Entity player , ArrayList<Enemy> targets) {
        if (getUsageTime() > 0 && player.getMp() > getManaCost()) {
            for(Enemy target : targets) {
                target.takeDamage(5);
            }
            player.setHp(player.getHp() + targets.size() * 5);
            player.fillMana(-40);
        }
        else if (player.getMp() > getManaCost()) {
            System.out.println("do not have enough mana");
        }
        else if (getUsageTime() <= 0)
            System.out.println("spell has been used");
    }


}
