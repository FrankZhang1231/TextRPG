package npc.mobs.regular;
import npc.mobs.Enemy;


import java.util.Random;

public class Goblin extends Enemy {

    private static final Random rand = new Random();

    public Goblin(int min, int max) {
        super("Goblin", min, max, 1.0,
                6, 1.25,
                2.0, 1.1);
    }
}
