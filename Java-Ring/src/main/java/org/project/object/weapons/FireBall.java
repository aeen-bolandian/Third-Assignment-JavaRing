package org.project.object.weapons;

import org.project.entity.Entity;

public class FireBall extends Weapon{
    public FireBall(int maxDamage, int manaCost) {
        super(maxDamage, manaCost);
    }

    public void use(Entity target) {
        checkBroke();
        if(!isBroke()) {
            target.takeDamage(getDamage());
            setDamage(getDamage() - 1);
        }
        else {
            System.out.println("Dragon has no fire :(");
        }
    }
}
