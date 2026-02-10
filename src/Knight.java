public class Knight extends PlayerClass {



    public Knight(String name) {
        super(name);
        setHealth(100);
        setAttack(1);

    }

    @Override
    public void describe() {
        System.out.println("You've chosen Knight who has high health, moderate attack \n" +
                "with a unique defense stat that lowers the amount of damage taken");
    }
}

