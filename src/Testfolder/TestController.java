package Testfolder;

import Programfolder.Controller.Controller;
import Programfolder.Model.Member;
import Programfolder.Model.MemberHandling;
import Programfolder.Model.SQLDUMMY;
import Programfolder.Model.ShipHandling;
import Programfolder.View.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Daniel on 2015-11-24.
 */
public class TestController {

    private Controller ctrl;
    private View v;
    private SQLDUMMY sql;
    private MemberHandling mh;
    private ShipHandling sh;

    @Before
    public void setUp() {
        sql = mock(SQLDUMMY.class);
        ctrl = mock(Controller.class);
        v = mock(View.class);
        mh = mock(MemberHandling.class);
        sh = mock(ShipHandling.class);
        ctrl = new Controller(sql, v, mh, sh);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testCommandControll() {
        ctrl.commandControll();
        verify(ctrl, Mockito.times(1)).commandControll();
    }

    @Test
    public void testAddNewCaptain() {
        when(v.getInput()).thenReturn("Mac", "Macsson");
        assertTrue(ctrl.addNewCaptain());
    }

    @Test
    public void testAddNewShip() {
        String memID = "MB666";
        String sn = "Name";
        String sc = "Class";
        String gc = "100";
        String sl = "500";
        String ng = "30";
        when(v.getInput()).thenReturn(memID, sn, sc, gc, sl, ng);

        assertTrue(ctrl.addNewShip());
    }

    @Test
    public void testChangeCaptain() {
        when(v.getInput()).thenReturn("MM666", "Farad", "Farahsson");
        assertTrue(ctrl.changeCaptain());
    }

    @Test
    public void testChangeShip() {
        when(v.getInput()).thenReturn("Name", "NewName", "NewClass", "200", "250", "60");
        assertTrue(ctrl.changeShip());
    }
}
