package Testfolder;

import Programfolder.Controller.Controller;
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
        assertEquals(true, ctrl.addNewCaptain());
    }
}
