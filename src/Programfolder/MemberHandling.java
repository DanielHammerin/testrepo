package Programfolder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Daniel on 2015-11-11.
 */
public class MemberHandling {

    Random randInt = new Random();
    SQLDUMMY sql;

    public MemberHandling(SQLDUMMY sqlIn) {
        sql = sqlIn;
    }

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
            sql.saveMember(newMember);
            return true;
        }
        catch (Exception e) {
            System.out.println("Error1.");
        }
        return false;
    }

    public boolean changeMember(Member mem, String n1, String n2) {
        try {
            ArrayList<Member> memArr = sql.getAllMembers();
            for (Member m : memArr) {
                if (m.equals(mem)) {
                    m.setMemberFirstName(n1);
                    m.setMemberLastName(n2);
                    m.setMemberID(ensureUniqueID(m, m.getMemberID()));
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error4.");
        }
        return false;
    }

    public boolean deleteMember(Member mem) {

        try {
            ArrayList<Member> memArr = sql.getAllMembers();
            ArrayList<Ship> shipArr = sql.getAllShips();
            for(Member m : memArr) {
                if (m.equals(mem)) {
                    sql.deleteMember(m);
                    for (Ship s : shipArr) {
                        if (s.getOwner().equals(mem)) {
                            sql.deleteShip(s);
                        }
                    }
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error2.");
        }
        return false;
    }

    public String ensureUniqueID(Member mem, String s) {
        try {
            ArrayList<Member> memArr = sql.getAllMembers();
            for (Member m : memArr) {
                if (m.getMemberID().equals(s)) {
                    s = String.valueOf(mem.getMemberFirstName().charAt(0)) +
                            String.valueOf(mem.getMemberLastName().charAt(0)) +
                            Integer.toString(randInt.nextInt(900) + 100);
                    ensureUniqueID(m, s);
                }
                else {
                    return s;
                }
            }
        }
        catch (Error e) {
            System.out.println("Error3.");
        }
        return s;
    }
}
