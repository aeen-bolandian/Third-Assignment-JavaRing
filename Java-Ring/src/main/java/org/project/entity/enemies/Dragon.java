package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.entity.players.Player;
import org.project.object.weapons.Weapon;

public class Dragon extends Enemy{
    public Dragon(String name, int hp, int mp, Weapon weapon) {
        super(name, hp, mp, weapon);
    }

    @Override
    public void attack(Entity target) {
        if(target instanceof Player player)
        {
            weapon.use(player);
        }
    }
}
