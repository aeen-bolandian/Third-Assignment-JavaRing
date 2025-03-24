package org.project.object.armors;

import org.project.entity.Entity;
import org.project.entity.players.Assassin;

public class AssassinArmor extends Armor {
    public AssassinArmor(int maxDefense, int repairCost) {
        super(maxDefense, repairCost);
    }

    @Override
    public void use(Entity target) {
        if (target instanceof Assassin assassin) {
            if(!isBroke()) {
                assassin.setDefense(assassin.getDefense() + getDefense());
                setDefense(getDefense() - 1);
            }
        }
        else if(isBroke()) {
            setBroke(true);
            System.out.println("Assassin Armor has been broken");
        }
        }
    }
