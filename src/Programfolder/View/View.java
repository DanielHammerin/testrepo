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
        else if (m.equals("enterfirstname")) {
            System.out.println("Please enter the new captain's first name.");
        }
        else if (m.equals("enterlastname")) {
            System.out.println("Please enter the new captain's last name.");
        }
        else if (m.equals("entercaptainid")) {
            System.out.println("Please enter the ID of the captain you wish to access.");
        }
        else if (m.equals("nosuchcaptain")) {
            System.out.println("There is no captain with that ID.");
        }
        else if (m.equals("entershipname")) {
            System.out.println("Please enter the new ship's name.");
        }
        else if (m.equals("entershipclass")) {
            System.out.println("Please enter the new ship's class.");
        }
        else if (m.equals("enterguncaliber")) {
            System.out.println("Please enter the new ship's gun caliber.");
        }
        else if (m.equals("enternguns")) {
            System.out.println("Please enter the new ship's number of guns.");
        }
        else if (m.equals("entershiplength")) {
            System.out.println("Please enter the new ship's length.");
        }
        else if (m.equals("shipaccess")) {
            System.out.println("Please enter the name of the ship you wish to access.");
        }
        else if (m.equals("cptaddcnfrm")) {
            System.out.println("Captain added successfully!");
        }
        else if (m.equals("cptaddfail")) {
            System.out.println("Something went wrong, new Captain not added.");
        }
        else if (m.equals("shipaddcnfrm")) {
            System.out.println("Ship added successfully!");
        }
        else if (m.equals("shipaddfail")) {
            System.out.println("Something went wrong, new Ship not added");
        }
        else if (m.equals("captainchanged")) {
            System.out.println("Captain data changes successfully.");
        }
        else if (m.equals("captainchangefail")) {
            System.out.println("Something went wrong, Captain's data not changed.");
        }
        else if (m.equals("")) {

        }
        else if (m.equals("")) {

        }
        else if (m.equals("")) {

        }
        else if (m.equals("")) {

        }

    }
}
