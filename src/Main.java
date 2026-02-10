import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

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

    }
}