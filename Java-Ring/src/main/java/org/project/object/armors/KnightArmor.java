package org.project.object.armors;

import org.project.entity.Entity;
import org.project.entity.players.Knight;

// TODO: UPDATE IMPLEMENTATION
public class KnightArmor extends Armor {

    public KnightArmor(int maxDefence, int repairCost) {
        super(maxDefence, repairCost);
    }

    // use method will increase defense power of Knight
    @Override
    public void use(Entity user) {
        Knight knight = (Knight) user;
        if(!isBroke() && isActive()) {
            knight.setDefense(knight.getDefense() + getDefense());
            setDefense(getDefense() - 1);
        }
        else if(isBroke()) {
            setBroke(true);
            System.out.println("Knight Armor has been broken");
        }
        else if(!isActive()) {
            System.out.println("Knight Armor is not active");
        }
    }
    // TODO: DESIGN ARMOR'S ATTRIBUTES IMPLEMENT THE CONSTRUCTOR
}