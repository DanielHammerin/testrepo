package Programfolder;

import java.util.ArrayList;

/**
 * Created by Daniel on 2015-11-15.
 */
public class SQLDUMMY {

    private static ArrayList<Member> memberList = new ArrayList<>();
    private static ArrayList<Ship> shipList = new ArrayList<>();

    public static ArrayList<Member> getAllMembers() {
        return memberList;
    }

    public static void saveMember(Member m) {
        memberList.add(m);
    }

    public static void deleteMember(Member memIn) {
        memberList.remove(memIn);
    }


    public static void saveShip(Ship newShip) {
        shipList.add(newShip);
    }
}
