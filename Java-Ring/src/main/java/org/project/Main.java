package org.project;

import org.project.entity.enemies.Dragon;
import org.project.entity.enemies.Enemy;
import org.project.entity.enemies.Goblin;
import org.project.entity.enemies.Skeleton;
import org.project.entity.players.Assassin;
import org.project.entity.players.Knight;
import org.project.entity.players.Player;
import org.project.entity.players.Wizard;
import org.project.object.armors.AssassinArmor;
import org.project.object.armors.KnightArmor;
import org.project.object.armors.MagicShield;
import org.project.object.consumables.Flask;
import org.project.object.consumables.InvisibleCloak;
import org.project.object.consumables.Spell;
import org.project.object.weapons.FireBall;
import org.project.object.weapons.Knife;
import org.project.object.weapons.Sword;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Scanner :
        Scanner scanner = new Scanner(System.in);

        // Knight :
        KnightArmor knightArmor = new KnightArmor(10, 10);
        Sword knightSword = new Sword(10, 10);
        Knight knight = new Knight("Drake", 100, 100, knightSword, knightArmor);

        // Assassin :
        AssassinArmor assassinArmor = new AssassinArmor(10, 10);
        Sword assassinSword = new Sword(10, 10);
        Assassin assassin = new Assassin("Phantom", 100, 100, knightSword, knightArmor);

        // Wizard :
        MagicShield magicShield = new MagicShield(10, 10);
        Sword magicSword = new Sword(10, 10);
        Wizard wizard = new Wizard("Merlin", 100, 200, magicSword, magicShield);

        // Consumable :
        Flask flask = new Flask(3, 10);
        InvisibleCloak invisibleCloak = new InvisibleCloak(5, 10);
        Spell spell = new Spell(10, 15);

        // Skeleton :
        ArrayList<Skeleton> skeletons = new ArrayList<>();
        ArrayList<Knife> knives = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String name = "skeleton " + (i + 1);
            knives.add(new Knife(2, 2));
            skeletons.add(new Skeleton(name, 5, 5, knives.get(i)));
        }
        boolean allSkeletonsAreDead = skeletons.stream().allMatch(Skeleton::isDead);

        // Goblin :
        ArrayList<Goblin> goblins = new ArrayList<>();
        ArrayList<Knife> goblinKnives = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String name = "skeleton " + (i + 1);
            goblinKnives.add(new Knife(2, 2));
            goblins.add(new Goblin(name, 5, 5, goblinKnives.get(i)));
        }
        boolean allGoblinsAreDead = goblins.stream().allMatch(Goblin::isDead);

        // Dragon :
        FireBall fireBall = new FireBall(20, 10);
        Dragon dragon = new Dragon("Volcanor", 50, 70, fireBall);

        // GAME LOOP :
        while ((!knight.isDead() && !wizard.isDead() && !assassin.isDead()) || (!dragon.isDead() && !allGoblinsAreDead && !allSkeletonsAreDead)) {
            /// ///////////////////////////////////////////////////////////////////////////////////////////////////
            if (!knight.isDead()) {
                if (!allSkeletonsAreDead) {
                    // attack mode
                    System.out.println(knight.getName() + " is Attacking to skeleton army");
                    System.out.println(skeletons.size() + " skeleton left");
                    System.out.println("(1) Normal Attack \n(2) Super Attack");
                    int attackChoice = scanner.nextInt();
                    switch (attackChoice) {
                        case 1: {
                            for (Skeleton skeleton : skeletons) {
                                knight.attack(skeleton);
                            }
                            break;
                        }
                        case 2: {
                            ArrayList<Enemy> enemies = new ArrayList<>();
                            for (Skeleton skeleton : skeletons) {
                                enemies.add((Enemy) skeleton);
                            }
                            knightSword.uniqueAbility(enemies, knight);
                            skeletons.clear();
                            for (int i = 0; i < enemies.size(); i++) {
                                skeletons.add((Skeleton) enemies.get(i));
                                if (skeletons.get(i).isDead() && !skeletons.get(i).getDeathTimes()) {
                                    skeletons.get(i).revive();
                                } else if (skeletons.get(i).isDead() && skeletons.get(i).getDeathTimes()) {
                                    skeletons.remove(i);
                                    knives.remove(i);
                                }
                            }
                            break;
                        }
                    }
                    // defense mode :
                    for (Skeleton skeleton : skeletons) {
                        if (knight.getHp() <= knight.getMaxHp()) {
                            knight.defend(knight);
                            System.out.println(knight.getName() + " is Defending ");
                        }
                        if (knightArmor.isBroke() && knight.getMp() >= knightArmor.getRepairCost()) {
                            knightArmor.repair();
                            System.out.println(knight.getName() + " Armor is Repairing ");
                        }
                        if (knight.getHp() <= 10) {
                            flask.use(knight);
                            System.out.println(knight.getName() + " is using flask ");
                        }
                        skeleton.attack(knight);
                    }
                }
                else {
                    System.out.println("Skeleton army has been destroyed");
                }
                if (!allGoblinsAreDead) {
                    // attack mode :
                    System.out.println(knight.getName() + " is Attacking to goblins");
                    System.out.println(skeletons.size() + " goblin left");
                    System.out.println("(1) Normal Attack \n(2) Super Attack");
                    int attackChoice = scanner.nextInt();
                    switch (attackChoice) {
                        case 1: {
                            for (Goblin goblin : goblins) {
                                knight.attack(goblin);
                            }
                            break;
                        }
                        case 2: {
                            ArrayList<Enemy> enemies = new ArrayList<>();
                            for (Goblin goblin : goblins) {
                                enemies.add((Enemy) goblin);
                            }
                            knightSword.uniqueAbility(enemies, knight);
                            goblins.clear();
                            for (int i = 0; i < enemies.size(); i++) {
                                if (!enemies.get(i).isDead())
                                    goblins.add((Goblin) enemies.get(i));
                                else {
                                    goblinKnives.remove(i);
                                    goblins.remove(i);
                                }
                            }
                            break;
                        }
                    }
                        // defense mode :
                        for (Goblin goblin : goblins) {
                            if (knight.getHp() <= knight.getMaxHp() / 2) {
                                knight.defend(knight);
                                System.out.println(knight.getName() + " is Defending ");
                            }
                            if (knightArmor.isBroke() && knight.getMp() >= knightArmor.getRepairCost()) {
                                knightArmor.repair();
                                System.out.println(knight.getName() + " Armor is Repairing ");
                            }
                            if (knight.getHp() <= 10) {
                                flask.use(knight);
                                System.out.println(knight.getName() + " is using flask ");
                            }
                            goblin.attack(knight);
                            goblin.stealMana(knight);
                            System.out.println("goblins are attacking and stealing mana");
                        }
                    }
                else {
                    System.out.println("Goblins have been destroyed");
                }
                if (!dragon.isDead()) {
                    // attack mode :
                    System.out.println(knight.getName() + " is Attacking to dragon");
                    knight.attack(dragon);
                    // defense mode :
                    if(knight.getHp() <= knight.getMaxHp() / 2) {
                        knight.defend(knight);
                        System.out.println(knight.getName() + " is Defending ");
                    }
                    if (knightArmor.isBroke() && knight.getMp() >= knightArmor.getRepairCost()) {
                        knightArmor.repair();
                        System.out.println(knight.getName() + " Armor is Repairing ");
                    }
                    if (knight.getHp() <= 10) {
                        flask.use(knight);
                        System.out.println(knight.getName() + " is using flask ");
                    }
                    dragon.attack(knight);
                }
                else
                    System.out.println(dragon.getName() + " is dead");
            }
            ///  /////////////////////////////////////////////////////////////////////////////////////////
            // assassin can not use unique ability because he has to be silent!
            if (!assassin.isDead()) {
                // attack mode
                if (!allSkeletonsAreDead) {
                    System.out.println(assassin.getName() + " is Attacking to skeleton army");
                    System.out.println(skeletons.size() + " skeleton left");
                    System.out.println(assassin.getName() + " can be invisible but he will be visible after attacking");
                    System.out.println("(1) invisible \n(2) visible");
                    int playerChoice = scanner.nextInt();
                    if (playerChoice == 1) {
                        invisibleCloak.use(assassin);
                    } else {
                        assassin.setInvisible(false);
                    }
                    System.out.println("press ENTER to attack");
                    scanner.nextLine();
                    assassin.attack(skeletons.get(0));
                    for (int i = 0; i < skeletons.size(); i++) {
                        if (skeletons.get(i).isDead() && !skeletons.get(i).getDeathTimes()) {
                            skeletons.get(i).revive();
                        } else if (skeletons.get(i).isDead() && skeletons.get(i).getDeathTimes()) {
                            skeletons.remove(i);
                            skeletons.remove(i);
                        }
                    }
                    // defense mode :
                    if(assassin.isInvisible()) {
                        assassin.takeDamage(0);
                        System.out.println(assassin.getName() + " is invisible");
                    }
                    else {
                        for (Skeleton skeleton : skeletons) {
                            if(assassin.getHp() <= assassin.getMaxHp() - 20 && !assassin.isInvisible()) {
                                invisibleCloak.use(assassin);
                            }
                            if(assassin.getHp() <= assassin.getMaxHp() / 2) {
                                assassin.heal();
                            }
                            if(assassinArmor.isBroke() && assassin.getMp() >= assassinArmor.getRepairCost()) {
                                assassinArmor.repair();
                            }
                            skeleton.attack(skeleton);
                        }
                    }
                    // final part :
                    if (invisibleCloak.getUsageTime() <= 0 || assassin.getMp() < invisibleCloak.getManaCost())
                        assassin.setInvisible(false);
                } else {
                    System.out.println("Skeleton army has been destroyed");
                }
                if (!allGoblinsAreDead) {
                    // attack mode :
                    System.out.println(knight.getName() + " is Attacking to goblins");
                    System.out.println(skeletons.size() + " goblin left");
                    System.out.println(assassin.getName() + " can be invisible but he will be visible after attacking");
                    System.out.println("(1) invisible \n(2) visible");
                    int playerChoice = scanner.nextInt();
                    assassin.setInvisible(playerChoice == 1);
                    System.out.println("press ENTER to attack");
                    scanner.nextLine();
                    assassin.attack(goblins.get(0));
                    if (goblins.get(0).isDead()) {
                        goblins.remove(0);
                        goblinKnives.remove(0);
                    }
                    // defense mode :
                    for (Goblin goblin : goblins) {
                        if(assassin.getHp() <= assassin.getMaxHp() - 20 && !assassin.isInvisible()) {
                            invisibleCloak.use(assassin);
                        }
                        if(assassin.getHp() <= assassin.getMaxHp() / 2) {
                            assassin.heal();
                        }
                        if(assassinArmor.isBroke() && assassin.getMp() >= assassinArmor.getRepairCost()) {
                            assassinArmor.repair();
                        }
                        goblin.attack(assassin);
                        goblin.stealMana(assassin);
                    }
                    // final part :
                    if (invisibleCloak.getUsageTime() <= 0 || assassin.getMp() < invisibleCloak.getManaCost())
                        assassin.setInvisible(false);
                } else {
                    System.out.println("Goblins have been destroyed");
                }
                if (!dragon.isDead()) {
                    // attack mode :
                    System.out.println(knight.getName() + " is Attacking to dragon");
                    System.out.println(assassin.getName() + " can be invisible but he will be visible after attacking");
                    System.out.println("(1) invisible \n(2) visible");
                    int playerChoice = scanner.nextInt();
                    assassin.setInvisible(playerChoice == 1);
                    System.out.println("press ENTER to attack");
                    scanner.nextLine();
                    assassin.attack(dragon);
                    // defense mode :

                    if(assassin.getHp() <= assassin.getMaxHp() - 20 && !assassin.isInvisible()) {
                        invisibleCloak.use(assassin);
                    }
                    if(assassin.getHp() <= assassin.getMaxHp() / 2) {
                        assassin.heal();
                    }
                    if(assassinArmor.isBroke() && assassin.getMp() >= assassinArmor.getRepairCost()) {
                        assassinArmor.repair();
                    }

                    dragon.attack(assassin);
                }
                // final part :
                if (invisibleCloak.getUsageTime() <= 0 || assassin.getMp() < invisibleCloak.getManaCost())
                    assassin.setInvisible(false);
                else {
                    System.out.println(dragon.getName() + " has been destroyed");
                }
            }
            /// ////////////////////////////////////////////////////////////////////////////////////////////////////

            if (!wizard.isDead()) {
                if (!allSkeletonsAreDead) {
                    System.out.println(wizard.getName() + " is Attacking to skeleton army");
                    System.out.println(skeletons.size() + " skeleton left");
                    System.out.println("would you like to use spell ? (1) yes (2) no");
                    int playerChoice = scanner.nextInt();
                    if (playerChoice == 1) {
                        ArrayList<Enemy> enemies = new ArrayList<>();
                        for (Skeleton skeleton : skeletons) {
                            enemies.add((Enemy) skeleton);
                        }
                        spell.SpellUse(wizard, enemies);
                        skeletons.clear();
                        for (int i = 0; i < enemies.size(); i++) {
                            skeletons.add((Skeleton) enemies.get(i));
                            if (skeletons.get(i).isDead() && !skeletons.get(i).getDeathTimes()) {
                                skeletons.get(i).revive();
                            } else if (skeletons.get(i).isDead() && skeletons.get(i).getDeathTimes()) {
                                skeletons.remove(i);
                                knives.remove(i);
                            }

                        }
                    } else {
                        if (wizard.getMp() >= 50) {
                            ArrayList<Enemy> enemies = new ArrayList<>();
                            for (Skeleton skeleton : skeletons) {
                                enemies.add((Enemy) skeleton);
                            }
                            wizard.magicAttack(enemies);
                            skeletons.clear();
                            for (int i = 0; i < enemies.size(); i++) {
                                skeletons.add((Skeleton) enemies.get(i));
                                if (skeletons.get(i).isDead() && !skeletons.get(i).getDeathTimes()) {
                                    skeletons.get(i).revive();
                                } else if (skeletons.get(i).isDead() && skeletons.get(i).getDeathTimes()) {
                                    skeletons.remove(i);
                                    knives.remove(i);
                                }
                            }
                            System.out.println(wizard.getName() + " is magic attacking to skeleton army");
                        }
                        if (wizard.getMp() >= 5) {
                            wizard.attack(skeletons.get(0));
                            System.out.println(wizard.getName() + " is attacking to skeleton army in normal mode");
                        } else
                            System.out.println(wizard.getName() + " has no more mana to attack");
                    }
                    // defense mode :
                    for (Skeleton skeleton : skeletons) {
                        if(wizard.getHp() <= wizard.getMaxHp() - 20) {
                            wizard.defend(wizard);
                        }
                        if(wizard.getHp() <= wizard.getMaxHp() / 2) {
                            wizard.heal();
                        }
                        if(magicShield.isBroke() && wizard.getMp() >= magicShield.getRepairCost()) {
                            magicShield.repair();
                        }
                        skeleton.attack(skeleton);
                    }
                } else
                    System.out.println("Skeleton army has been destroyed");
                if (!allGoblinsAreDead) {
                    System.out.println(wizard.getName() + " is Attacking to goblins");
                    System.out.println(goblins.size() + " goblin left");
                    System.out.println("would you like to use spell ? (1) yes (2) no");
                    int playerChoice = scanner.nextInt();
                    if (playerChoice == 1) {
                        ArrayList<Enemy> enemies = new ArrayList<>();
                        for (Goblin goblin : goblins) {
                            enemies.add((Enemy) goblin);
                        }
                        spell.SpellUse(wizard, enemies);
                        goblins.clear();
                        for (int i = 0; i < enemies.size(); i++) {
                            goblins.add((Goblin) enemies.get(i));
                            if (goblins.get(i).isDead()) {
                                goblins.remove(i);
                                goblinKnives.remove(i);
                            }
                        }
                    } else {
                        if (wizard.getMp() >= 50) {
                            ArrayList<Enemy> enemies = new ArrayList<>();
                            for (Goblin goblin : goblins) {
                                enemies.add((Enemy) goblin);
                            }
                            wizard.magicAttack(enemies);
                            goblins.clear();
                            for (int i = 0; i < enemies.size(); i++) {
                                goblins.add((Goblin) enemies.get(i));
                                if (goblins.get(i).isDead()) {
                                    goblins.remove(i);
                                    goblinKnives.remove(i);
                                }
                            }
                            System.out.println(wizard.getName() + " is magic attacking to goblins");
                        } else if (wizard.getMp() >= 5) {
                            wizard.attack(goblins.get(0));
                        } else
                            System.out.println(wizard.getName() + " has no more mana to attack");
                    }
                    // defense mode :
                    for (Goblin goblin : goblins) {
                        if(wizard.getHp() <= wizard.getMaxHp() - 20) {
                            wizard.defend(wizard);
                        }
                        if(assassin.getHp() <= wizard.getMaxHp() / 2) {
                            wizard.heal();
                        }
                        if(magicShield.isBroke() && wizard.getMp() >= magicShield.getRepairCost()) {
                            magicShield.repair();
                        }
                        goblin.attack(wizard);
                        goblin.stealMana(wizard);
                    }

                } else
                    System.out.println("Goblins have been destroyed");
                if (!dragon.isDead()) {
                    // attack mode :
                    System.out.println(wizard.getName() + " is Attacking Dragon");
                    System.out.println("press ENTER to attack");
                    scanner.nextLine();
                    if (wizard.getMp() > 5)
                        wizard.attack(dragon);
                    else
                        System.out.println("has no more mana to attack");
                    // defense mode :
                    if(wizard.getHp() <= wizard.getMaxHp() - 20) {
                        wizard.defend(wizard);
                    }
                    if(assassin.getHp() <= wizard.getMaxHp() / 2) {
                        wizard.heal();
                    }
                    if(magicShield.isBroke() && wizard.getMp() >= magicShield.getRepairCost()) {
                        magicShield.repair();
                    }
                    dragon.attack(wizard);
                }
            }
        }
        if (dragon.isDead() && allGoblinsAreDead && allSkeletonsAreDead)
            System.out.println("WE HAVE A WINNER!");
        else if(knight.isDead() && wizard.isDead() && assassin.isDead())
            System.out.println("GAME OVER!");
    }
}