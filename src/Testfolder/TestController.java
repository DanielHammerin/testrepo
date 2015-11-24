package Testfolder;

import Programfolder.Controller.Controller;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Daniel on 2015-11-24.
 */
public class TestController {

    private Controller ctrl;

    @Before
    public void setUp() {
        ctrl = mock(Controller.class);
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
        String n1 = "Mac";
        String n2 = "McGuyver";

        when(ctrl.addNewCaptain().addMember(n1, n2)).thenReturn(true);

        ctrl.addNewCaptain(n1, n2);
        verify(ctrl, times(1)).commandControll();

        boolean check = ctrl.addNewCaptain().addMember(n1, n2);
        verify(ctrl, times(1)).addMember(n1, n2);

        assertTrue(check);
    }
}
