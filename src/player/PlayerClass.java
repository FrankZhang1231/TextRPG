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
    protected Weapons weaponName;
    protected String armorName;
    protected boolean haveWep = false;
    protected boolean haveArmor = false;

    private HashMap<String, InventoryItems> inventory = new HashMap<>();


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

    public String getWeapon() { return this.weaponName.getName(); }

    public String getArmor() { return this.armorName; }

    public void attack(Enemy a) {
        System.out.println("\nYou dealt " + this.attack + " damage to " + a.getName() + ".");
        a.takeDamage(this.attack);
    }

    public void expNeeded(int level) {
        this.maxExp = (int)(20 * Math.pow(1.5, level - 1));
    }

    public void gainExp(Enemy a) {
        System.out.println("You have gained " + a.getExp() + " Exp.");
        this.exp += a.getExp();
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

    public void fullHeal() {
        this.health = this.maxHp;
    }

    public void addInv(Weapons e) {
        inventory.compute(e.getName(), (name, item) -> {
            if (item == null) return new InventoryItems(e);
            item.addQuantity(1);
            return item;
        });
    }

    public void displayInv() {
        System.out.println("---------= Equipment ----------");
        System.out.println("Weapon: " + (haveWep ? getWeapon() : "None"));
        System.out.println("Armor: " + (haveArmor ? getArmor() : "None"));

        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.\n");
            return;
        }

        System.out.println("Your inventory:");
        for (InventoryItems item : inventory.values()) {
            Weapons weapon = item.getWeapon();
            System.out.println("- (" + weapon.getType() + ") " + weapon.getName() +
                    " -> Atk: " + weapon.getAttack() +
                    "| x" + item.getQuantity());
        }

        System.out.println("---------------------------------------");

        List<String> options = new ArrayList<>();

        if (!inventory.isEmpty()) {
            options.add("[1] Equip Weapon");
            options.add("[2] Equip Armor");
            options.add("[3] Sell Items");
            options.add("[4] Back");
        }

        options.forEach(System.out::println);

        String pChoice = input.nextLine();

        if (!inventory.isEmpty()) {
            switch (pChoice) {
                case ("1") -> equipWep();
                case ("2") -> System.out.println("Hello");
                case ("3") -> sellItem();
            }
        }
        else {
            System.out.println("Not a valid option");
        }

    }

    public void sellItem() {
        System.out.println("What is the name of the item you want to sell: ");
        String pChoice = input.nextLine();

        String name;
        int amount;

        InventoryItems item = inventory.get(pChoice);
        if (item == null) {
            System.out.println("You don’t have that item in your inventory.");
        } else {
            while (true) {
                name = item.getWeapon().getName();
                System.out.println("How many of " + name + " would you like to sell?");
                try {
                    amount = Integer.parseInt(input.nextLine());
                    System.out.println("You entered: " + amount);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    continue;
                }
                if (amount > 0 && amount <= item.getQuantity()) {
                    item.deleteItem(amount);

                    if (item.getQuantity() == 0) {
                        inventory.remove(name);
                    }
                    System.out.println("You sold " + amount + " " + name);
                    break;

                } else {
                    System.out.println("Please enter a valid amount to sell.");
                }
            }
        }
    }

    public void equipWep() {
        System.out.println("What is the name of the weapon you want to equip: ");
        String pChoice = input.nextLine();


        InventoryItems item = inventory.get(pChoice);

        Weapons oldWep = this.weaponName;

        if (item == null) {
            System.out.println("You don’t own that weapon.");
            return;
        } else {
            if (this.haveWep) {
                this.weaponName = item.getWeapon();
                this.attack -= oldWep.getAttack();
                this.attack += item.getWeapon().getAttack();
                addInv(oldWep);
            } else {
                this.weaponName = item.getWeapon();
                this.attack += item.getWeapon().getAttack();
                this.haveWep = true;
            }
        }
        item.deleteItem(1);
        if (item.getQuantity() == 0) {
            inventory.remove(item.getWeapon().getName());
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
    public boolean death() { return this.health <= 0; }
}
