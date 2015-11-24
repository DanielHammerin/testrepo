package Programfolder.Controller;

import Programfolder.Model.SQLDUMMY;
import Programfolder.View.View;

/**
 * Created by Daniel on 2015-11-24.
 */
public class Controller {
    private SQLDUMMY sql;
    private View view;

    public Controller(SQLDUMMY sqlIn, View v) {
        sql = sqlIn;
        view = v;
    }
    public boolean commandControll() {
        while (true) {
            view.displayheader();

        }
    }
}
