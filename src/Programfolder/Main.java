package Programfolder;

import Programfolder.Controller.Controller;
import Programfolder.Model.MemberHandling;
import Programfolder.Model.SQLDUMMY;
import Programfolder.Model.ShipHandling;
import Programfolder.View.View;

/**
 * Created by Daniel on 2015-11-24.
 */
public class Main {
    public static void main(String[] args) {

        SQLDUMMY sql = new SQLDUMMY();
        View v = new View();
        MemberHandling mh = new MemberHandling(sql);
        ShipHandling sh = new ShipHandling(sql);
        Controller ctrl = new Controller(sql, v, mh, sh);

        while (ctrl.commandControll());
    }
}
