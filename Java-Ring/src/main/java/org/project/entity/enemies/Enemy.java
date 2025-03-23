package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public abstract class Enemy implements Entity {
    Weapon weapon;
    private int hp;
    private int mp;
    private final int maxHp;
    private final int maxMp;
    private final String name;
    private boolean isDead;

    public Enemy(String name, int hp, int mp, Weapon weapon) {
        this.hp = hp;
        this.mp = mp;
        maxHp = hp;
        maxMp = mp;
        this.name = name;

        this.weapon = weapon;
        isDead = false;
    }

    // TODO: (BONUS) UPDATE THE FORMULA OF TAKING DAMAGE
    @Override
    public void takeDamage(int damage) {
        hp -= damage;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) { this.hp = hp; }
    public int getMaxHp() {return maxHp; }

    public int getMp() {
        return mp;
    }
    public void setMp(int mp) { this.mp = mp; }
    public int getMaxMp() {return maxMp; }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public void defend(Entity target){}

    @Override
    public boolean isDead() { return isDead; }
    public void setDead(boolean isDead) { this.isDead = isDead; }

    public String getName() { return name; }

    @Override
    public void heal() {}

    @Override
    public void fillMana(int mana){}
}
