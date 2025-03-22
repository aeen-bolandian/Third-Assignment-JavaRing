package org.project.object.armors;

import org.project.entity.Entity;
import org.project.object.Object;

import java.io.Serializable;

// TODO: UPDATE IMPLEMENTATION
public abstract class Armor implements Object {
    private int defense;
    private final int maxDefense;
    private int durability;
    private final int maxDurability;

    private boolean isBroke;

    public Armor(int defense, int durability) {
        this.defense = defense;
        this.durability = durability;
        this.maxDefense = defense;
        this.maxDurability = durability;
        this.isBroke = false;
    }

    public void checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
        }
    }

    // TODO: (BONUS) UPDATE THE REPAIR METHOD
    // check the repair condition (mana) on main method
    public void repair() {
        isBroke = false;
        defense = maxDefense;
        durability = maxDurability;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {this.defense = defense;}

    public int getDurability() {
        return durability;
    }
    public void setDurability(int durability) {this.durability = durability;}

    public boolean isBroke() {
        return isBroke;
    }
    public void setBroke(boolean broke) {
        isBroke = broke;
    }
}
