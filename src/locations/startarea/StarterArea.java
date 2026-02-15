package locations.startarea;

import player.PlayerClass;
import unifunct.PlayerMenu;

import java.util.*;
import java.util.function.Consumer;

import static player.PlayerClass.input;

public class StarterArea {

    private static final String location = "starter";

    public static void run(PlayerClass player) {
        System.out.println("Now you find yourself standing at the edge of a dense forest. The trees tower above you, their leaves fluttering in the breeze.");
        System.out.println("The forest stretches in all directions, a maze of shadowed paths, sun-dappled clearings, and the occasional trickle of a hidden stream.");
        System.out.println("Paths wind into the woods, disappearing into the unknown. The atmosphere is quiet but alive, as if the forest itself is watching.");
        System.out.println("Where will your journey take you first?");

        int steps = 0;
        String[] step = new String[9];
        Random rand = new Random();

        Map<String, Consumer<PlayerClass>> starterActions = new HashMap<>();
        starterActions.put("1", PlayerClass::showStats); // Show stats
        Consumer<PlayerClass> moveAction = p -> {
            System.out.println("You move forward into the forest...");
        };
        starterActions.put("2", moveAction);
        starterActions.put("3", moveAction);
        starterActions.put("4", moveAction);


        for (int i = 0; i < step.length; i++) {
            int roll = rand.nextInt(100);
            if (roll < 60) step[i] = "mob";
            else if (roll < 80) step[i] = "treasure";
            else if (roll < 90) step[i] = "trap";
            else step[i] = "encounter";
        }

        System.out.println(Arrays.toString(step));


        while (steps < step.length) {
            System.out.println("\nRoom " + (steps + 1) + "/9");
            System.out.println("Choose an action:");
            System.out.println("[1] Show Stats");
            System.out.println("[2] Move Forward");
            System.out.println("[3] Explore Left");
            System.out.println("[4] Explore Right");

            String pChoice = input.nextLine().trim();
            Set<String> movementChoices = Set.of("2", "3", "4");

            Consumer<PlayerClass> action = starterActions.get(pChoice);
            if (action != null) {
                action.accept(player);
                if (movementChoices.contains(pChoice)) {
                    System.out.println("Encounter type: " + step[steps]);
                    steps++;
                }
            } else {
                System.out.println("Not a valid option.");
            }
        }
    }
}
