package events;

import npc.mobs.Enemy;
import npc.mobs.regular.Goblin;
import player.PlayerClass;

import static unifunct.BattleManager.input;

public class Tutorial {

    public static void tutorial(PlayerClass a) {
        int minLevel = 1;
        int maxLevel = 1;

        System.out.println("\nAs you step forward, the forest grows quiet...");
        System.out.println("Suddenly, a rustle bursts from the bushes!");

        Enemy b = new Goblin(minLevel, maxLevel);

        System.out.println("\nA wild Lvl." + b.getLevel() + " " + b.getName() + " appears!\n");

        System.out.println("=== Combat Tutorial ===");
        System.out.println("Combat is turn-based.");
        System.out.println("You act first, then the enemy responds.");
        System.out.println("Reduce the enemy's HP to 0 to win.");
        System.out.println("If your HP reaches 0, you are defeated.");
        System.out.println("\nPress ENTER to continue...");
        input.nextLine();

        int turn = 1;

        while (true) {

            System.out.println("------------- Turn " + turn + " -------------");
            System.out.println(a.getName() + ": " + a.getHealth() + "/" + a.getMaxHp() + " HP");
            System.out.println(b.getName() + " (Lvl " + b.getLevel() + "): " +
                    b.getHealth() + "/" + b.getMaxHp() + " HP\n");

            if (turn == 1) {
                System.out.println("Your turn!");
                System.out.println("Choose an action.");
                System.out.println("Attacking deals damage based on your Attack stat.\n");
            }

            String pChoice;
            boolean valid = false;


            while (!valid) {
                System.out.println("What will you do next:");
                System.out.println("[1] Attack");
                System.out.println("[2] Run (80% Success rate)");

                pChoice = input.nextLine();

                switch (pChoice) {
                    case "1" -> {
                        a.attack(b);
                        valid = true;
                    }
                    case "2" -> System.out.println("You cannot run from the first battle.");
                    default -> System.out.println("Not a valid option.");
                }
            }


            if (b.death()) {
                System.out.println("\n" + b.getName() + " is defeated!");
                System.out.println("Defeating enemies grants Experience Points (EXP).");
                System.out.println("Earn enough EXP to level up and grow stronger.\n");
                a.gainExp(b);
                break;
            }

            System.out.println("\n" + b.getName() + " attacks!");
            b.attack(a);

            if (turn == 1) {
                System.out.println("Enemies attack after your turn.");
                System.out.println("Managing your health is key to survival.\n");
            }

            if (a.death()) {
                System.out.println("\nYou have been defeated...");
                System.out.println("Do not fear — this is only the beginning of your journey.");
                break;
            }

            turn++;
        }

        System.out.println("\nThe forest falls silent once more.");
        System.out.println("You feel a little more prepared for what lies ahead...");
    }
}
