package Testfolder;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import Programfolder.Member;
import Programfolder.MemberHandling;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * Created by Daniel on 2015-11-11.
 */
public class TestMemberHandling extends TestCase{

    MemberHandling memhandling = new MemberHandling();

    @Test
    public void testAddMemberReturnsTrue() throws Exception {
        String n1 = "Mike";
        String n2 = "Johnsson";

        assertTrue(memhandling.addMember(n1, n2));
    }

    @Test
    public void testEnsureUniqueID() throws Exception {
        Member tempMem = new Member();
        tempMem.setMemberFirstName("Adam");
        tempMem.setMemberLastName("Eden");

        String tempMemID = "AE899";
        tempMem.setMemberID(tempMemID);

        assertEquals(memhandling.ensureUniqueID(tempMem, tempMemID.charAt(0)), "A");            //Ensure that first char in first name == first char of ID
        assertEquals(memhandling.ensureUniqueID(tempMem, tempMemID).charAt(1), "E");            //Ensure that first char in last name == second char of ID
        assertEquals(memhandling.ensureUniqueID(tempMem, tempMemID).length(), 5);               //Ensure that length of ID is 5 chars long.
    }
}
