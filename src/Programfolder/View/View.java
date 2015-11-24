package Programfolder.View;

import java.util.Scanner;

/**
 * Created by Daniel on 2015-11-24.
 */
public class View {

    public void displayheader() {
        System.out.println("=========================================================================");
        System.out.println("Welcome to battleships. This service lets you register your battleships.");
        System.out.println("Press 'NC' to add a new captain.");
        System.out.println("Press 'NS' to add a new ship to a captain's reserve.");
        System.out.println("Press 'CC' to change a captain's name.");
        System.out.println("Press 'CS' to change a ship's data.");
        System.out.println("Press 'DC' to delete a captain.");
        System.out.println("Press 'DS' to delete a ship.");
        System.out.println("=========================================================================");
    }

    public String getInput() {
        Scanner sc = new Scanner(System.in);
        String entry = sc.nextLine();
        return entry.toLowerCase();
    }

    /*
     * Method for printing out messages from the controller.
     */
    public void displayPrintMessages(String m) {
        if (m.equals("invalid")) {
            System.out.println("Invalid input.");
        }
    }
}
