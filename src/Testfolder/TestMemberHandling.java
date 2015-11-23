package Testfolder;

import Programfolder.Member;
import Programfolder.MemberHandling;
import Programfolder.SQLDUMMY;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by Daniel on 2015-11-11.
 */
public class TestMemberHandling {

    private MemberHandling memhandling;
    private SQLDUMMY sqldummy;
    private ArrayList<Member> mockedMemberList;

    @Before
    public void setUp() {
        sqldummy = mock(SQLDUMMY.class);
        memhandling = new MemberHandling(sqldummy);
        mockedMemberList = new ArrayList<>();
    }

    @After
    public void tearDown() {
        mockedMemberList.clear();
    }

    @Test
    public void testAddMemberReturnsTrue() throws Exception {
        String n1 = "Mike";
        String n2 = "Johnsson";

        assertTrue(memhandling.addMember(n1, n2));
    }

    @Test
    public void testChangeMemberReturnsTrue() throws Exception {
        when(sqldummy.getAllMembers()).thenReturn(mockedMemberList);

        Member tempMem = new Member();
        tempMem.setMemberFirstName("Swagrid");
        tempMem.setMemberLastName("McLovin");
        tempMem.setMemberID("SM666");
        mockedMemberList.add(tempMem);

        Member checkMem = new Member();
        ArrayList<Member> memArr = sqldummy.getAllMembers();
        for (Member m : memArr) {                   // Look through all saved members
            if (m.equals(tempMem)) {                // If match, save to checkMem
                checkMem = m;
            }
        }
        assertTrue(tempMem.equals(checkMem));            // Make sure they are really equal.

        String newfirstname = "Darius";
        String newlastname = "DunkMaster";
        assertTrue(memhandling.changeMember(tempMem, newfirstname, newlastname));

    }

    @Test
    public void testDeleteMemberReturnsTrue() throws Exception {

        Member tempMem = new Member();              //Create new member.
        tempMem.setMemberFirstName("Michael");
        tempMem.setMemberLastName("Jordan");
        tempMem.setMemberID("MJ222");

        sqldummy.saveMember(tempMem);               //Save the new member in dummy DB

        Member checkMem = new Member();
        ArrayList<Member> memArr = sqldummy.getAllMembers();
        for (Member m : memArr) {                   // Look through all saved members
            if (m.equals(tempMem)) {                // If match, save to checkMem
                checkMem = m;
            }
        }
        assertTrue(tempMem.equals(checkMem));            // Make sure they are really equal.

        assertTrue(memhandling.deleteMember(tempMem));          // Assert deletion of member.
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
}
