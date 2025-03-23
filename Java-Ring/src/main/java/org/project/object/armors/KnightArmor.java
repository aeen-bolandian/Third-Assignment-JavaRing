package org.project.object.armors;

import org.project.entity.Entity;
import org.project.entity.players.Knight;

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
    public void use(Entity user) {
        Knight knight = (Knight) user;
        if(!isBroke()) {
            knight.setDefense(knight.getDefense() + damageReduction);
            damageReduction -= 1;
        }
        else
            setBroke(true);
    }
    // TODO: DESIGN ARMOR'S ATTRIBUTES IMPLEMENT THE CONSTRUCTOR
}