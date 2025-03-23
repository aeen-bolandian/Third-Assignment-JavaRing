package org.project.object.armors;

import org.project.entity.Entity;
import org.project.object.Object;

import java.io.Serializable;

// TODO: UPDATE IMPLEMENTATION
public abstract class Armor implements Object {
    private int defense;
    private final int maxDefense;
    private final int repairCost;
    private boolean isBroke;
    private boolean isActive;

    public Armor(int maxDefense, int repairCost) {
        this.defense = maxDefense;
        this.maxDefense = maxDefense;
        this.repairCost = repairCost;
        this.isBroke = false;
        this.isActive = false;
    }

    public void checkBreak() {
        if (defense <= 0) {
            isBroke = true;
            defense = 0;
        }
    }

    // TODO: (BONUS) UPDATE THE REPAIR METHOD
    // check the repair condition (mana) on main method
    public void repair() {
        isBroke = false;
        defense = maxDefense;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {this.defense = defense;}

    public boolean isBroke() {
        return isBroke;
    }
    public void setBroke(boolean broke) {
        isBroke = broke;
    }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { this.isActive = active; }
}
