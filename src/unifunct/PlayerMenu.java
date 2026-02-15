package unifunct;

import locations.startarea.StarterArea;
import npc.mobs.Enemy;
import npc.mobs.regular.Goblin;
import player.PlayerClass;

import java.util.ArrayList;
import java.util.List;

import static player.PlayerClass.input;

public class PlayerMenu {
    public static void playerMenu(PlayerClass player, String location) {
        List<String> options = new ArrayList<>();
        options.add("[1] Show Stats");

        switch(location.toLowerCase()) {
            case "main" -> {
                options.add("[2] Encounter Goblin");
                options.add("[3] Go to Forest");
            }
        }

        System.out.println("What will you do next: ");
        for (String option : options) {
            System.out.println(option);
        }

        String pChoice = input.nextLine();

        switch (location.toLowerCase()) {
            case ("main") -> {
                switch (pChoice) {
                    case "1" -> player.showStats();
                    case "2" -> {
                        Enemy mob = new Goblin(1, 2);
                        BattleManager.battle(player, mob);
                    }
                    case "3" -> StarterArea.run(player);
                    default -> System.out.println("Not a valid option.");
                }
            }
        }
    }
}

