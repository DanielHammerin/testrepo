package Programfolder;

import Programfolder.Controller.Controller;
import Programfolder.Model.SQLDUMMY;
import Programfolder.View.View;

/**
 * Created by Daniel on 2015-11-24.
 */
public class Main {
    public static void main(String[] args) {

        SQLDUMMY sql = new SQLDUMMY();
        View v = new View();
        Controller ctrl = new Controller(sql, v);

        while (ctrl.commandControll());
    }
}
