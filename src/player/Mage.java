package player;

public class Mage extends PlayerClass {

    private int mana = 100;
    private int overflow = 1;

    public Mage(String name) {
        super(name, 100, 1);
    }

    @Override
    public String getUniqueStat() {
        return "Mana: " + this.mana;
    }

    @Override
    public void describe() {
        System.out.println("You've chosen Mage who has moderate health, high attack\n" +
                "with chance of causing \"overflow\" (extra dmg).\n");
    }
}