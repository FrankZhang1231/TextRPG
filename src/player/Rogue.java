package player;

public class Rogue extends PlayerClass {

    private int agility = 0;

    public Rogue(String name) {
        super(name, 65, 2);
    }

    @Override
    public void describe() {
        System.out.println("You've chosen Rogue who has low health, high attack\n" +
                "with chance of dodging enemy attacks.\n");
    }

    @Override
    public void showStats() {
        System.out.println("\n===== PLAYER STATS =====" +
                "\nName: " + this.name +
                "\nLevel: " + this.level +
                "\nHealth: " + health +
                "\nAttack: " + attack +
                "\nAgility: " + agility+
                "\nMoney: " + this.money+
                "\nExp: " + this.exp + "/" + this.maxExp +
                "\n========================\n");
    }
}