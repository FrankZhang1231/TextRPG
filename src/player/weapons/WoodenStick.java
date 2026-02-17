package player.weapons;

import player.Weapons;

public class WoodenStick extends Weapons {

    private static final int ATTACK = 1;
    private static final String TYPE = "Weapon";

    public WoodenStick () {
        super(
                "WoodenStick",
                TYPE,
                ATTACK
        );
    }
}
