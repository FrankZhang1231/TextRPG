import events.Tutorial;
import locations.startarea.StarterArea;
import npc.mobs.Enemy;
import npc.mobs.regular.Goblin;
import player.*;
import unifunct.BattleManager;
import unifunct.PlayerMenu;

import java.util.*;

import java.util.*;

import static player.PlayerClass.input;

public class Main {

    public static final String location = "main";

    public static void main(String[] args) {

        System.out.print("You awaken in a dense, misty forest. The last thing you remember is a bright flash of light and then… nothing. \n" +
                "A strange voice whispers: \"chosen one\" what is your name?: ");
        String name = input.nextLine();

        System.out.print("Welcome " + name + ". The world of Magnolia overrun by monsters and demons, awaits you." +
                        "\nA sturdy Knight - your armor may be light now, but your courage will carry you through." +
                        "\nA cunning Rogue - Quick and clever, your wits may be your greatest weapon." +
                        "\nA Mage of promise - Your magic is raw, but your mind holds endless possibilities." +
                "\nPlease choose your destiny: "
                );

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
        System.out.println("A strange visual with numbers appeared inside your mind.");
        player.showStats();

        Tutorial.tutorial(player);

        while(true) {
            PlayerMenu.playerMenu(player, location);
        }
    }
}
