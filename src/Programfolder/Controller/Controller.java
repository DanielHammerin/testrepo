package Programfolder.Controller;

import Programfolder.Model.SQLDUMMY;
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

    public Controller(SQLDUMMY sqlIn, View v) {
        sql = sqlIn;
        view = v;
    }

    public boolean commandControll() {
        while (true) {
            view.displayheader();
            String cmd = view.getInput();

            if (cmd.equals(AddNewCaptain)) {

            }
            else if (cmd.equals(AddNewShip)) {

            }
            else if (cmd.equals(ChangeCaptain)) {

            }
            else if (cmd.equals(ChangeShip)) {

            }
            else if (cmd.equals(DeleteCaptain)) {

            }
            else if (cmd.equals(DeleteShip)) {

            }
            else if (cmd.equals(exit)) {
                return false;
            }
            else {
                view.displayPrintMessages("invalid");

            }
        }
    }
}
