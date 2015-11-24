package Testfolder;

import Programfolder.Main;
import Programfolder.View.View;
import org.junit.After;
import static org.junit.Assert.*;
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

    @Test
    public void testDisplayHeader() {
        view.displayheader();
        verify(view, Mockito.times(1)).displayheader();
    }

    @Test
    public void testGetInput() {
        String expected = "Return String Works.";
        when(view.getInput()).thenReturn(expected);

        String res = view.getInput();
        verify(view, Mockito.times(1)).getInput();

        assertEquals(expected, res);
    }

    @Test
    public void testDisplayPrintMessages() {
        String message = "StringForCorrectSystemOutPrint";

        view.displayPrintMessages(message);
        verify(view, Mockito.times(1)).displayPrintMessages();
    }
}
