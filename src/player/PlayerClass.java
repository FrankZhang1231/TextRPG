package player;

import npc.mobs.Enemy;

abstract public class PlayerClass {
    protected String name;
    protected int health;
    protected int attack;
    protected int money = 0;
    protected int exp = 0;


    public PlayerClass(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public int getAttack() { return this.attack; }

    public String getName() { return this.name; }

    public void attack(Enemy a) {
        System.out.println("\nYou dealt " + this.attack + " damage to " + a.getName() + ".");
        a.takeDamage(this.attack);
    }

    public void takeDamage(int a) {
        this.health = Math.max(this.health - a, 0);
        System.out.println("You have " + this.health + " health remaining.");
    }

    public boolean death() { return this.health <= 0; }

    abstract public void describe();
    abstract public void showStats();
}
