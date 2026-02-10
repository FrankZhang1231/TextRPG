public class Rogue extends PlayerClass {

    private int agility;

    public Rogue(String name) {
        super(name);
        setHealth(70);
        setAttack(2);
        setAgility(1);
    }

    public void setAgility(int a) {
        agility = a;
    }

    @Override
    public void describe() {
        System.out.println("You've chosen Rogue who has low health, high attack\n" +
                "with chance of dodging enemy attacks.");
    }
}