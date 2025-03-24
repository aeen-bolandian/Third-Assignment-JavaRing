package org.project.object.armors;

import org.project.entity.Entity;
import org.project.entity.players.Wizard;

public class MagicShield extends Armor {
    public MagicShield(int maxDefense, int repairCost) {
        super(maxDefense, repairCost);
    }

    @Override
    public void use(Entity target) {
        if(target instanceof Wizard wizard) {
            if(!isBroke()) {
                wizard.setDefense(wizard.getDefense() + getDefense());
                setDefense(getDefense() - 1);
            }
            else if(isBroke()) {
                setBroke(true);
                System.out.println("Magic Shield has been broken");
            }

        }
    }
}
