package Programfolder.Model;

import Programfolder.Model.Member;
import Programfolder.Model.Ship;

import java.util.ArrayList;

/**
 * Created by Daniel on 2015-11-15.
 */
public class SQLDUMMY {

    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Ship> shipList = new ArrayList<>();

    public ArrayList<Member> getAllMembers() {
        return memberList;
    }

    public void saveMember(Member m) {
        memberList.add(m);
    }

    public void deleteMember(Member memIn) {
        memberList.remove(memIn);
    }


    public void saveShip(Ship newShip) {
        shipList.add(newShip);
    }

    public ArrayList<Ship> getAllShips() {
        return shipList;
    }

    public void deleteShip(Ship s) {
        shipList.remove(s);
    }
}
