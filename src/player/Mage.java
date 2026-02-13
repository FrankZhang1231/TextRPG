package player;

public class Mage extends PlayerClass {

    private int mana = 100;
    private int overflow = 1;

    public Mage(String name) {
        super(name, 100, 1);
    }

    @Override
    public void describe() {
        System.out.println("You've chosen Mage who has moderate health, high attack\n" +
                "with chance of causing \"overflow\" (extra dmg).\n");
    }

    @Override
    public void showStats() {
        System.out.println("\n===== PLAYER STATS =====" +
                "\nName: " + this.name +
                "\nLevel: " + this.level +
                "\nHealth: " + health +
                "\nAttack: " + attack +
                "\nMana: " + mana +
                "\nMoney: " + this.money+
                "\nExp: " + this.exp + "/" + this.maxExp +
                "\n========================\n");
    }
}