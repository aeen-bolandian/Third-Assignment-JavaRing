package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

import java.util.ArrayList;

// wizard have 200 mana and turns magic to attack power and has got special healer spell which heals player and damages enemy
// can heal himself for three times without manaCost and heal with -10 mana after that
public class Wizard extends Player{

    private int defense;
    private int healTimes;

    public Wizard(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
        healTimes = 3;
        defense = 5;
    }

    public void attack(Entity target) {
        fillMana(-5);
        target.takeDamage(10);
    }

    // use magic attack when enemy number is too much
    public void magicAttack(ArrayList<Enemy> targets) {
        for (Enemy target : targets) {
            target.takeDamage(20);
        }
        fillMana(-50);
    }

    public void takeDamage(int damage) {
        setHp(getHp() - damage + defense);
    }

    @Override
    public void heal(){
        if(healTimes > 0){
            healTimes--;
            setHp(getMaxHp());
        }
        else if(getMp() >= (getMaxHp() - getMp())) {
            fillMana(-(getMaxHp() - getHp()));
            setHp(getMaxHp());
        }
        else
            System.out.println(getName() + " Can not heal");
    }

    public int getHealTimes() { return healTimes; }
    public void setHealTimes(int times) { healTimes = times; }

    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

}
