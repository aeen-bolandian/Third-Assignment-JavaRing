package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public abstract class Player implements Entity {
    protected String name;
    Weapon weapon;
    Armor armor;
    private int hp;
    private final int maxHP;
    private int mp;
    private final int maxMP;

    public Player(String name, int hp, int mp, Weapon weapon, Armor armor) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.maxHP = hp;
        this.maxMP = mp;

        this.weapon = weapon;
        this.armor = armor;
    }

    @Override
    public void attack(Entity target) {
        target.takeDamage(weapon.getDamage());
    }

    @Override
    public void defend(Entity target) {
        armor.setActive(true);
        armor.use(target);
        // TODO: (BONUS) IMPLEMENT A DEFENSE METHOD FOR SHIELDS
    }

    // TODO: (BONUS) UPDATE THE FORMULA OF TAKING DAMAGE
    @Override
    public void takeDamage(int damage) {
        hp -= damage - armor.getDefense();
    }

    @Override
    public void heal() {
    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > maxMP) {
            mp = maxMP;
        }
    }


    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {this.hp = hp;}

    @Override
    public int getMaxHp() {
        return maxHP;
    }

    @Override
    public int getMp() {
        return mp;
    }
    public void setMp(int mp) {this.mp = mp;}

    @Override
    public int getMaxMp() {
        return maxMP;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    @Override
    public boolean isDead(){
        return hp <= 0;
    }
}
