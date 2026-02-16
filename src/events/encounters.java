package events;

import npc.mobs.Enemy;
import player.PlayerClass;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class encounters {

    private static final Random rand = new Random();

    public static Enemy mob(Map<String, Supplier<Enemy>> enemyGen) {
        List<String> keys = new ArrayList<>(enemyGen.keySet());
        String randomKey = keys.get(rand.nextInt(keys.size()));
        return enemyGen.get(randomKey).get();
    }

    public static void encounter(PlayerClass player, String location) {
        Map<String, Consumer<PlayerClass>> events = new HashMap<>();
        String chosen;

        switch (location) {
            case ("starter") -> {
                events.put("rest", PlayerClass::fullHeal);
                chosen = choosing(events);
                switch(chosen) {
                    case("rest") ->{
                        System.out.println("You found a deserted camp spot and decide to rest for a day.");
                        events.get(chosen).accept(player);
                        System.out.println("You wake up feeling refreshed.");
                    }
                }
            }
        }
    }

    private static String choosing(Map<String, Consumer<PlayerClass>> events) {
        List<String> keys = new ArrayList<>(events.keySet());
        return keys.get(rand.nextInt(keys.size()));
    }
}
