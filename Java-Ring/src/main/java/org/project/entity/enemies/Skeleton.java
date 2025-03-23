package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public class Skeleton extends Enemy{

    private boolean firstDie;

    public Skeleton(String name, int hp, int mp, Weapon weapon) {
        super(name, hp, mp, weapon);
        firstDie = false;
    }

    @Override
    public void attack(Entity target) {
        weapon.use(target);
    }

    public void revive() {
        if(isDead() && !firstDie) {
            setDead(false);
            System.out.println("skeleton revived");
            setDeathTimes(true);
        }
    }

    public boolean getDeathTimes() { return firstDie; }
    public void setDeathTimes(boolean firstDie) { this.firstDie = firstDie; }

    // TODO: DESIGN ENEMY'S WEAPON AND ARMOR AND IMPLEMENT THE CONSTRUCTOR
}
