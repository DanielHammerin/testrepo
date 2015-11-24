package Testfolder;

import Programfolder.View.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

/**
 * Created by Daniel on 2015-11-24.
 */
public class TestView {

    private View view;

    @Before
    public void setUp() {
        view = mock(View.class);
    }

    @After
    public void tearDown() {

    }
    /*
     * Test for main method to enter the program.
     */
    @Test
    public void testMain() {
        Main m = mock(Main.class);
        m.main();
        verify(m, Mockito.times(1)).main();
    }

    @Test
    public void testDisplayHeader() {
        view.displayheader();
        verify(view, Mockito.times(1)).displayheader();
    }
}
