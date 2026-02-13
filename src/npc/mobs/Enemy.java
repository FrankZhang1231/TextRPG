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

    public Enemy(String name,int level, int health, int attack, double expMulti) {
        this.name = name;
        this.health = health;
        this.maxHp = health;
        this.attack = attack;
        this.level = level;
        this.exp = calculateExp(level, expMulti);
    }

    public String getName() { return this.name; }

    public int getAttack() { return this.attack; }

    public int getLevel() { return this.level; }

    public int getHealth() { return this.health; }

    public int getMaxHp() { return this.maxHp; }

    public int getExp() { return this.exp; }

    public void attack(PlayerClass a) {
        System.out.println(this.name + " dealt " + this.attack + " damage to you.");
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
