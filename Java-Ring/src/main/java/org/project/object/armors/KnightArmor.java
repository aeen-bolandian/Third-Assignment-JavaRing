package org.project.object.armors;

import org.project.entity.Entity;

// TODO: UPDATE IMPLEMENTATION
public class KnightArmor extends Armor {

    private final int repairCost;
    private int damageReduction;
    public KnightArmor(int defense, int durability) {
        super(defense, durability);
        repairCost = 10;
        damageReduction = 5;
    }

    public int getRepairCost() {
        return repairCost;
    }

    @Override
    public void use(Entity target) {
        if(damageReduction > 0) {
            setDefense(getDefense() + damageReduction);
            damageReduction -= 1;
        }
        else
            setBroke(true);
    }
    // TODO: DESIGN ARMOR'S ATTRIBUTES IMPLEMENT THE CONSTRUCTOR
}