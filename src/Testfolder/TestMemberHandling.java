package Testfolder;

import static org.junit.Assert.*;

import Programfolder.MemberHandling;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * Created by Daniel on 2015-11-11.
 */
public class TestMemberHandling extends TestCase{

    MemberHandling memhandling = new MemberHandling();

    @Test
    public void testAddMemberReturnsTrue() throws Exception{
        String n1 = "Mike";
        String n2 = "Johnsson";

        assertTrue(memhandling.addMember(n1, n2));
    }
}
