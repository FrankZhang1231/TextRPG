package npc.mobs.regular;
import npc.mobs.Enemy;

public class Goblin extends Enemy {

    private static final double EXP_MULTIPLIER = 1.0;
    private static final double HP_MULTIPLIER = 6.0;
    private static final double HP_EXPONENT = 1.25;
    private static final double ATK_MULTIPLIER = 2.0;
    private static final double ATK_EXPONENT = 1.1;

    public Goblin(int minLevel, int maxLevel) {
        super("Goblin",
                minLevel,
                maxLevel,
                EXP_MULTIPLIER,
                HP_MULTIPLIER,
                HP_EXPONENT,
                ATK_MULTIPLIER,
                ATK_EXPONENT);
    }
}
