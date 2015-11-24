package Testfolder;

import Programfolder.Controller.Controller;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
}
