package org.project.object.consumables;

import org.project.object.Object;

import java.io.Serializable;

// TODO: UPDATE IMPLEMENTATION
public abstract class Consumable implements Object {
    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */

    private int manaCost;
    private int usageTime;

    public Consumable(int usageTime , int manaCost) {
        this.usageTime = usageTime;
        this.manaCost = manaCost;
    }

    public int getUsageTime() { return usageTime; }
    public int getManaCost() { return manaCost; }
    public void setUsageTime(int usageTime) { this.usageTime = usageTime; }
    public void setManaCost(int manaCost) { this.manaCost = manaCost; }


}
