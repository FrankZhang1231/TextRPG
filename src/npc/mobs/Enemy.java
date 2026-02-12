package npc.mobs;

import player.PlayerClass;

public class Enemy {
    protected String name;
    protected int health;
    protected int attack;

    public Enemy(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public String getName() { return this.name; }

    public int getAttack() { return this.attack; }

    public void attack(PlayerClass a) {
        System.out.println(this.name + " dealt " + this.attack + " damage to you.");
        a.takeDamage(this.attack);
    }

    public void takeDamage(int a) {
        this.health = Math.max(this.health - a, 0);
        System.out.println(this.name + " have " + this.health + " health remaining.\n");
    }

    public boolean death() {
        return health <= 0;
    }

}
