package Testfolder;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Daniel on 2015-11-11.
 */
public class TestMemberHandling {

    MemberHandling memhandling = new MemberHandling();

    @Test
    public void testAddMemberReturnsTrue() {
        String n1 = "Mike";
        String n2 = "Johnsson";

        assertTrue(memhandling.addMember(n1, n2));
    }
}
