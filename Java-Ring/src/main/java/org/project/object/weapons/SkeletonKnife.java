package org.project.object.weapons;

import org.project.entity.Entity;

public class SkeletonKnife extends Weapon{
    public SkeletonKnife(int damage, int manaCost) {
        super(damage, manaCost);
    }

    public void use(Entity target) {
        checkBroke();
        if(!isBroke()) {
            target.takeDamage(getDamage());
            setDamage(getDamage() - 1);
        }
        else {
            System.out.println("Skeleton Knife has been broken!");
        }
    }
}
