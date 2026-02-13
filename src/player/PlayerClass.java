package player;

import npc.mobs.Enemy;

abstract public class PlayerClass {
    protected String name;
    protected int health;
    protected int maxHp;
    protected int attack;
    protected int level = 1;
    protected int money = 0;
    protected int exp = 0;
    protected int maxExp;


    public PlayerClass(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.maxHp = health;
        expNeeded(this.level);
    }

    public int getAttack() { return this.attack; }

    public String getName() { return this.name; }

    public int getHealth() { return this.health; }

    public int getMaxHp() { return this.maxHp; }

    public void attack(Enemy a) {
        System.out.println("\nYou dealt " + this.attack + " damage to " + a.getName() + ".");
        a.takeDamage(this.attack);
    }

    public void expNeeded(int level) {
        this.maxExp = (int)(20 * Math.pow(1.2, level - 1));
    }

    public void gainExp(Enemy a) {
        System.out.println("You have gained " + a.getExp() + " Exp.");
        this.exp += a.getExp();
        if (this.exp >= maxExp) {
            while (this.exp >= maxExp) {
                levelUp();
            }
        }
        else {
            System.out.println("Exp: " + this.exp + "/" + this.maxExp + "\n");
        }
    }

    public void levelUp() {
        System.out.println("You have leveled up");
        int remainExp = this.exp - this.maxExp;
        this.level += 1;
        this.exp = remainExp;
        expNeeded(this.level);
        System.out.println("Level: " + this.level);
        System.out.println("Exp: " + this.exp + "/" + this.maxExp + "\n");
    }

    public void takeDamage(int a) {
        this.health = Math.max(this.health - a, 0);
        //System.out.println("You have " + this.health + " health remaining.");
    }



    public boolean death() { return this.health <= 0; }

    abstract public void describe();
    abstract public void showStats();
}
