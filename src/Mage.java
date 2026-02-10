public class Mage extends PlayerClass {

    private int mana;

    public Mage(String name) {
        super(name);
        setHealth(100);
        setAttack(1);
        setMana(100);
    }

    public void setMana(int a) {
        mana = a;
    }

    @Override
    public void describe() {
        System.out.println("You've chosen mage who has moderate health, high attack\n" +
                "with defense penetration.");
    }
}