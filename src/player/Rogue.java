package player;

public class Rogue extends PlayerClass {

    private int agility = 0;

    public Rogue(String name) {
        super(name, 65, 2);
    }

    @Override
    public String getUniqueStat() {
        return "Agility: " + this.agility;
    }

    @Override
    public void describe() {
        System.out.println("You've chosen Rogue who has low health, high attack\n" +
                "with chance of dodging enemy attacks.\n");
    }
}