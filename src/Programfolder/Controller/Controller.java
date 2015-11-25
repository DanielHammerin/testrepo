package Programfolder.Controller;

import Programfolder.Model.*;
import Programfolder.View.View;

/**
 * Created by Daniel on 2015-11-24.
 */
public class Controller {
    private String AddNewCaptain =    "nc";
    private String AddNewShip    =    "ns";
    private String ChangeCaptain =    "cc";
    private String ChangeShip    =    "cs";
    private String DeleteCaptain =    "dc";
    private String DeleteShip    =    "ds";
    private String exit          =    "exit";

    private SQLDUMMY sql;
    private View view;
    private MemberHandling memHandler;
    private ShipHandling shipHandler;

    public Controller(SQLDUMMY sqlIn, View v, MemberHandling mh, ShipHandling sh) {
        sql = sqlIn;
        view = v;
        memHandler = mh;
        shipHandler = sh;
    }

    public boolean commandControll() {
        while (true) {
            view.displayheader();
            String cmd = view.getInput();

            if (cmd.equals(AddNewCaptain)) {
                boolean b = addNewCaptain();
                if (b == true) {
                    view.displayPrintMessages("cptaddcnfrm");
                }
                else {
                    view.displayPrintMessages("cptaddfail");
                }
            }
            else if (cmd.equals(AddNewShip)) {
                boolean b = addNewShip();
                if (b ==true) {
                    view.displayPrintMessages("shipaddcnfrm");
                }
                else {
                    view.displayPrintMessages("shipaddfail");
                }
            }
            else if (cmd.equals(ChangeCaptain)) {
                boolean b = changeCaptain();
                if (b == true) {
                    view.displayPrintMessages("captainchanged");
                }
                else {
                    view.displayPrintMessages("captainchangefail");
                }
            }
            else if (cmd.equals(ChangeShip)) {
                boolean b = changeShip();
                if (b == true) {
                    view.displayPrintMessages("shipchanged");
                }
                else {
                    view.displayPrintMessages("shipchangedfail");
                }
            }
            else if (cmd.equals(DeleteCaptain)) {
                boolean b = deleteCaptain();

            }
            else if (cmd.equals(DeleteShip)) {
                view.displayPrintMessages("shipaccess");
                String sn = view.getInput();
                Ship ship = new Ship();
                for (Ship s : sql.getAllShips()) {
                    if (s.getShipName().equals(sn)) {
                        ship = s;
                    }
                }
                shipHandler.deleteShip(ship);
            }
            else if (cmd.equals(exit)) {
                return false;
            }
            else {
                view.displayPrintMessages("invalid");
            }
        }
    }
    public boolean addNewCaptain() {
        boolean check = false;
        try {
            view.displayPrintMessages("enterfirstname");
            String n1 = view.getInput();
            view.displayPrintMessages("enterlastname");
            String n2 = view.getInput();

            memHandler.addMember(n1, n2);
            check = true;
        }
        catch (Exception e) {
        }
        return check;
    }

    public boolean addNewShip() {
        boolean check = false;
        try {
            view.displayPrintMessages("entercaptainid");
            String memID = view.getInput();
            Member mem = new Member();
            for (Member m : sql.getAllMembers()) {
                if (m.getMemberID().equals(memID)) {
                    mem = m;
                } else {
                    view.displayPrintMessages("nocushcaptain");
                }
            }
            view.displayPrintMessages("entershipname");
            String shipName = view.getInput();
            view.displayPrintMessages("entershipclass");
            String shipClass = view.getInput();
            view.displayPrintMessages("enterguncaliber");
            int shipGunCaliber = Integer.parseInt(view.getInput());
            view.displayPrintMessages("enternguns");
            int shipnguns = Integer.parseInt(view.getInput());
            view.displayPrintMessages("entershiplength");
            int shiplength = Integer.parseInt(view.getInput());

            shipHandler.addShip(mem, shipName, shipClass, shipGunCaliber, shipnguns, shiplength);
            check = true;
        }
        catch (Exception e) {
        }
        return check;
    }

    public boolean changeCaptain() {
        boolean b = false;
        try {
            view.displayPrintMessages("entercaptainid");
            String memID = view.getInput();
            Member mem = new Member();
            for (Member m : sql.getAllMembers()) {
                if (m.getMemberID().equals(memID)) {
                    mem = m;
                } else {
                    view.displayPrintMessages("nosuchcaptain");
                }
            }
            view.displayPrintMessages("enternewfirstname");
            String n1 = view.getInput();
            view.displayPrintMessages("enternewlastname");
            String n2 = view.getInput();

            memHandler.changeMember(mem, n1, n2);
            b = true;
        }
        catch (Exception e) {
        }
        return b;
    }

    public boolean changeShip() {
        boolean b = false;
        try {
            view.displayPrintMessages("shipaccess");
            String sn = view.getInput();
            Ship ship = new Ship();
            for (Ship s : sql.getAllShips()) {
                if (s.getShipName().equals(sn)) {
                    ship = s;
                }
            }
            view.displayPrintMessages("entershipname");
            String shipName = view.getInput();
            view.displayPrintMessages("entershipclass");
            String shipClass = view.getInput();
            view.displayPrintMessages("enterguncaliber");
            int shipGunCaliber = Integer.parseInt(view.getInput());
            view.displayPrintMessages("enternguns");
            int shipnguns = Integer.parseInt(view.getInput());
            view.displayPrintMessages("entershiplength");
            int shiplength = Integer.parseInt(view.getInput());

            shipHandler.changeShip(ship, shipName, shipClass, shipGunCaliber, shiplength, shipnguns);
            b = true;
        }
        catch (Exception e) {
        }
        return b;
    }

    public boolean deleteCaptain() {
        boolean b = false;
        try {
            view.displayPrintMessages("entercaptainid");
            String memID = view.getInput();
            Member mem = new Member();
            for (Member m : sql.getAllMembers()) {
                if (m.getMemberID().equals(memID)) {
                    mem = m;
                }
                else {
                    view.displayPrintMessages("nocushcaptain");
                    return deleteCaptain();
                }
            }
            memHandler.deleteMember(mem);
            b = true;
        }
        catch (Exception e) {
        }
        return b;
    }
}
