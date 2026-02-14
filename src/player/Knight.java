package player;

public class Knight extends PlayerClass {

    private int defense = 1;

    public Knight(String name) {
        super(name, 100, 1);
    }

    @Override
    public String getUniqueStat() {
        return "Defense: " + this.defense;
    }

    @Override
    public void describe() {
        System.out.println("You've chosen Knight who has high health, moderate attack \n" +
                "with a unique defense stat that lowers the amount of damage taken.\n");
    }
}

