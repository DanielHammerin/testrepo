package Programfolder.Model;

import Programfolder.Model.Member;

/**
 * Created by Daniel on 2015-11-20.
 */
public class Ship {

    private Member owner;
    private String shipName;
    private String shipClass;
    private int shipGunCaliber;
    private int shipNGuns;
    private int shipLength;

    public Member getOwner() {
        return owner;
    }
    public String getShipName() {
        return shipName;
    }
    public String getShipClass() {
        return shipClass;
    }
    public int getShipGunCaliber() {
        return shipGunCaliber;
    }
    public int getShipNGuns() {
        return shipNGuns;
    }
    public int getShipLength() {
        return shipLength;
    }


    public void setOwner(Member m) {
        this.owner = m;
    }
    public void setShipName(String s) {
        this.shipName = s;
    }
    public void setShipClass(String s) {
        this.shipClass = s;
    }
    public void setShipGunCaliber(int n) {
        this.shipGunCaliber = n;
    }
    public void setShipNGuns(int n) {
        this.shipNGuns = n;
    }
    public void setShipLength(int n) {
        this.shipLength = n;
    }
}
