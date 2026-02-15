package npc.mobs;

import player.PlayerClass;
import java.util.*;

abstract public class Enemy {
    protected String name;
    protected int health;
    protected int attack;
    protected int level;
    protected int exp;
    protected int maxHp;

    private static final Random rand = new Random();

    public Enemy(String name, int minLevel, int maxLevel, double expMulti,
                 double hpMultiplier, double hpExponent,
                 double atkMultiplier, double atkExponent) {
        this.name = name;
        this.level = rand.nextInt(maxLevel - minLevel + 1) + minLevel;
        int baseHealth = (int) (Math.round(Math.pow(this.level * hpMultiplier, hpExponent)));
        int healthVariation = (int) (baseHealth * 0.1);
        this.maxHp = this.health = baseHealth + rand.nextInt(healthVariation + 1);
        int baseAtk = (int) Math.round(Math.pow(this.level * atkMultiplier, atkExponent));
        int atkVariation = (int) (baseAtk * 0.1);
        this.attack = baseAtk + rand.nextInt(atkVariation + 1);
        this.exp = calculateExp(this.level, expMulti);
    }

    public String getName() { return this.name; }

    public int getAttack() { return this.attack; }

    public int getLevel() { return this.level; }

    public int getHealth() { return this.health; }

    public int getMaxHp() { return this.maxHp; }

    public int getExp() { return this.exp; }

    public void attack(PlayerClass a) {
        System.out.println(this.name + " dealt " + this.attack + " damage to you.\n");
        a.takeDamage(this.attack);
    }

    public void takeDamage(int a) {
        this.health = Math.max(this.health - a, 0);
        //System.out.println(this.name + " have " + this.health + " health remaining.\n");
    }

    protected int calculateExp(int level, double multiplier) {
        return (int)(level * 5 * multiplier + Math.random() * 3);
    }

    public boolean death() {
        return health <= 0;
    }


}
