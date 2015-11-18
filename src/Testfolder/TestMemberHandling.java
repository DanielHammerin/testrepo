package Testfolder;

import Programfolder.Member;
import Programfolder.MemberHandling;
import Programfolder.SQLDUMMY;
import org.junit.Test;
import junit.framework.TestCase;

import java.util.ArrayList;

import static org.junit.Assert.*;

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

        assertEquals(memhandling.ensureUniqueID(tempMem, tempMemID).charAt(0), 'A');            //Ensure that first char in first name == first char of ID
        assertEquals(memhandling.ensureUniqueID(tempMem, tempMemID).charAt(1), 'E');            //Ensure that first char in last name == second char of ID
        assertEquals(memhandling.ensureUniqueID(tempMem, tempMemID).length(), 5);               //Ensure that length of ID is 5 chars long.
    }

    @Test
    public void testDeleteMember() {
        Member tempMem = new Member();              //Create new member.
        tempMem.setMemberFirstName("Michael");
        tempMem.setMemberLastName("Jordan");
        tempMem.setMemberID("MJ222");

        SQLDUMMY.saveMember(tempMem);               //Save the new member in dummy DB

        Member checkMem = new Member();
        ArrayList<Member> memArr = SQLDUMMY.getAllMembers();
        for (Member m : memArr) {                   // Look through all saved members
            if (m.equals(tempMem)) {                // If match, save to checkMem
                checkMem = m;
            }
        }
        assertEquals(tempMem, checkMem);            // Make sure they are really equal.

        memhandling.deleteMember(tempMem);          // Delete the member.

        ArrayList<Member> updatedMemArr = SQLDUMMY.getAllMembers();          //Reload all saved members.
        boolean recheck = false;
        for (Member m :updatedMemArr) {             // Re check saved members to ensure it's gone.
            if (m.equals(tempMem)) {                // If it persists, set recheck to true.
                recheck = true;
            }
        }
        assertFalse(recheck);                       //Assert that the deleted member is deleted through the boolean.
    }
}
