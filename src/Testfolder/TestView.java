package Testfolder;

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
        view = new View();
    }

    @After
    public void tearDown() {

    }
    @Test
    public void testDisplayHeader() {
        verify(view, Mockito.times(1)).displayheader();
    }
}
