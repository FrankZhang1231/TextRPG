import npc.mobs.Enemy;
import npc.mobs.regular.Goblin;
import player.*;
import java.util.*;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Hello traveller, welcome to the world of Magnolia. What is your name?: ");
        String name = input.nextLine();

        System.out.print("Welcome " + name + ", you can choose between being a knight, rogue, or mage.\n" +
                "What is your future path?: ");
        PlayerClass player = null;

        boolean chooseClass = true;
        while (chooseClass) {
            String pClass = input.nextLine();
            if (pClass.equalsIgnoreCase("knight")) {
                player = new Knight(name);
                chooseClass = false;
            }
            else if (pClass.equalsIgnoreCase("rogue")) {
                player = new Rogue(name);
                chooseClass = false;
            }
            else if (pClass.equalsIgnoreCase("mage")) {
                player = new Mage(name);
                chooseClass = false;
            }
            else {
                System.out.print("Please choose a valid class: ");
            }
        }

        player.describe();

        boolean playerAction = true;

        while(true) {
            pAction(player);
        }

    }

    public static void pAction(PlayerClass b) {
        System.out.println("What will you do next: " +
                "\n[1] Show Stats" +
                "\n[2] Encounter Goblin");
        String pChoice = input.nextLine();
        if (pChoice.equals("1")) {
            b.showStats();
        } else if (pChoice.equals("2")) {
            Enemy mob = new Goblin();
            battle(b, mob);
        }
    }

    public static void battle(PlayerClass a, Enemy b) {
        System.out.println("\nA wild " + b.getName() + " appears!\n");
        int turn = 1;
        while (true) {

            System.out.println("Turn: " + turn);
            System.out.println("What will you do next: \n[1] Attack");
            String pChoice = input.nextLine();
            if (pChoice.equals("1")) {
                a.attack(b);
            }

            if (b.death()) {
                System.out.println(b.getName() + " is defeated!");
                break;
            }

            System.out.println(b.getName() + " attacks!");
            b.attack(a);

            if (a.death()) {
                System.out.println("You have been defeated...");
                break;
            }

            System.out.println("\n---------------------------------\n");
            turn++;
        }
    }
}
