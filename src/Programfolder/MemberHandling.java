package Programfolder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Daniel on 2015-11-11.
 */
public class MemberHandling {

    Random randInt = new Random();

    public boolean addMember(String n1, String n2) {
        try {
            Member newMember = new Member();

            newMember.setMemberFirstName(n1);
            newMember.setMemberLastName(n2);

            //Create the unique member ID and check it so ensure its originality.
            String temp;
            temp = String.valueOf(newMember.getMemberFirstName().charAt(0)) +
                    String.valueOf(newMember.getMemberLastName().charAt(0)) +
                    Integer.toString(randInt.nextInt(900) + 100);
            newMember.setMemberID(ensureUniqueID(newMember, temp));
            return true;
        }
        catch (Exception e) {
            System.out.println("Error.");
        }
        return false;
    }

    public String ensureUniqueID(Member mem, String s) {

        try {
            ArrayList<Member> memArr = SQLDUMMY.getAllMembers();
            for (Member m : memArr) {
                if (m.getMemberID().equals(mem.getMemberID())) {
                    String newID;
                    newID = String.valueOf(mem.getMemberFirstName().charAt(0)) +
                            String.valueOf(mem.getMemberLastName().charAt(0)) +
                            Integer.toString(randInt.nextInt(900) + 100);
                    mem.setMemberID(newID);
                    ensureUniqueID(mem, newID);
                }
                else {
                    return s;
                }
            }
        }
        catch (Error e) {
            System.out.println("Error.");
        }
        return s;
    }
}
