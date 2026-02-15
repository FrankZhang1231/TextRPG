package player;

import npc.mobs.Enemy;
import java.util.Scanner;
import java.util.*;

abstract public class PlayerClass {

    public static final Scanner input = new Scanner(System.in);

    protected String name;
    protected int health;
    protected int maxHp;
    protected int attack;
    protected int level = 1;
    protected int money = 0;
    protected int exp = 0;
    protected int maxExp;
    protected int statPoints = 0;


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
//        if (this.exp >= maxExp) {
//            while (this.exp >= maxExp) {
//                levelUp();
//            }
//        }
//        else {
//            System.out.println("Exp: " + this.exp + "/" + this.maxExp + "\n");
//        }
        if (this.exp < this.maxExp) {
            System.out.println("Exp: " + this.exp + "/" + this.maxExp + "\n");
        } else {
            while (this.exp >= this.maxExp) {
                levelUp();
            }
        }
    }

    public void levelUp() {
        System.out.println("You have leveled up");
        int remainExp = this.exp - this.maxExp;
        this.level += 1;
        this.exp = remainExp;
        this.statPoints += 3;
        expNeeded(this.level);
        this.maxHp += 5;
        this.health = this.maxHp;
        if (this.level % 2 == 0) {
            this.attack += 1;
        }
        System.out.println("Level: " + this.level);
        System.out.println("Exp: " + this.exp + "/" + this.maxExp + "\n");
    }

    public void takeDamage(int a) {
        this.health = Math.max(this.health - a, 0);
        //System.out.println("You have " + this.health + " health remaining.");
    }

    public boolean run() {
        int successChance = 80;
        int roll = (int)(Math.random() * 101);
        return roll <= successChance;
    }

    public boolean death() { return this.health <= 0; }

    public void showStats() {
        while (true) {
            printStats();  // extracted method

            List<String> options = new ArrayList<>();
            if (statPoints > 0) {
                options.add("[1] Upgrade Health (+5 HP)");
                options.add("[2] Upgrade Attack (+1 ATK)");
                options.add("[3] Back");
            } else {
                options.add("[1] Back");
            }

            options.forEach(System.out::println);

            String choice = input.nextLine();
            if (statPoints > 0) {
                switch (choice) {
                    case "1" -> {
                        health += 5;
                        statPoints--;
                    }
                    case "2" -> {
                        attack += 1;
                        statPoints--;
                    }
                    case "3" -> {
                        return; // back
                    }
                    default -> System.out.println("Not a valid option.");
                }
            } else {
                if (choice.equals("1")) return;
                System.out.println("Not a valid option.");
            }
        }
    }

    private void printStats() {
        System.out.println("\n===== PLAYER STATS =====" +
                "\nName: " + name +
                "\nLevel: " + level +
                "\nHealth: " + health + "/" + maxHp +
                "\nAttack: " + attack +
                "\n" + getUniqueStat() +
                "\nMoney: " + money +
                "\nExp: " + exp + "/" + maxExp +
                "\nStat Points Remaining: " + statPoints +
                "\n========================");
    }

    abstract public void describe();
    abstract public String getUniqueStat();
}
