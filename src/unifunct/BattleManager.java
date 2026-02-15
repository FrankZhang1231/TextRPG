package unifunct;

import npc.mobs.Enemy;
import player.PlayerClass;
import java.util.*;

import static player.PlayerClass.input;

public class BattleManager {

    public static void battle(PlayerClass a, Enemy b) {
        System.out.println("\nA wild Lvl." + b.getLevel() + " " + b.getName() + " appears!\n");
        int turn = 1;
        while (true) {

            System.out.println("------------- Turn " + turn + " -------------");
            System.out.println(a.getName() + ": " + a.getHealth() + "/" + a.getMaxHp() + " HP");
            System.out.println(b.getName() + " (Lvl " + b.getLevel() + "): " + b.getHealth() + "/" + b.getMaxHp() + " HP\n");
            System.out.println("What will you do next: \n[1] Attack" +
                    "\n[2] Run (Success rate 80%)");


            String pChoice = input.nextLine();

            switch (pChoice) {
                case "1" -> a.attack(b);
                case "2" -> {
                    if (a.run()) {
                        System.out.println("You've successfully ran away!");
                        return;
                    } else {
                        String[] failMessages = {
                                "You tried to run away, but tripped on a stick.",
                                "The " + b.getName() + " ran in front and blocks your path!",
                                "You stumble and fall, can't escape!",
                                "You tried to run, but your shoelace got caught!"
                        };

                        int index = (int)(Math.random() * failMessages.length);
                        System.out.println(failMessages[index]);
                        System.out.println("You failed to escape!");
                    }
                }
                default -> System.out.println("Not a valid option.");
            }

            if (b.death()) {
                System.out.println(b.getName() + " is defeated!");
                a.gainExp(b);
                break;
            }

            System.out.println(b.getName() + " attacks!");
            b.attack(a);

            if (a.death()) {
                System.out.println("You have been defeated...");
                break;
            }

            turn++;

        }
    }
}
