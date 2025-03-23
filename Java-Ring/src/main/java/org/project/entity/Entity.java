package org.project.entity;

public interface Entity {
    String getName();

    void attack(Entity target);

    void defend(Entity target);

    void heal();

    void fillMana(int mana);

    void takeDamage(int damage);

    int getMaxHp();

    int getMaxMp();

    boolean isDead();

    int getMp();

    int getHp();

    void setMp(int mp);

    void setHp(int hp);

    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */
}
