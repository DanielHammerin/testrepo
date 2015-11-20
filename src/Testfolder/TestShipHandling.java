package Testfolder;

import Programfolder.Member;
import Programfolder.SQLDUMMY;
import Programfolder.Ship;
import Programfolder.ShipHandling;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Daniel on 2015-11-19.
 */
public class TestShipHandling extends TestCase{

    ShipHandling shipHandling = new ShipHandling();

    @Test
    public void testAddShipReturnsTrue() throws Exception {
        Member tempMem = new Member();                  //Owner
        tempMem.setMemberFirstName("Maximum");
        tempMem.setMemberLastName("Crispness");
        tempMem.setMemberID("MC999");

        String shipName = "Victorium";
        String shipClass = "Battleship";
        int shipGunCaliber = 305;
        int shipLength = 320;
        int shipNGuns = 10;

        assertTrue(shipHandling.addShip(tempMem, shipName, shipClass, shipGunCaliber, shipLength, shipNGuns));
    }

    @Test
    public void testChangeShipReturnsTrue() throws Exception {
        Member tempMem = new Member();              //Temp owner
        tempMem.setMemberFirstName("Maximum");
        tempMem.setMemberLastName("Crispness");
        tempMem.setMemberID("MC999");

        String shipName = "Victorium";
        String shipClass = "Battleship";
        int shipGunCaliber = 305;
        int shipLength = 320;
        int shipNGuns = 10;

        assertTrue(shipHandling.addShip(tempMem, shipName, shipClass, shipGunCaliber, shipLength, shipNGuns)); //Add ship

        Ship tempShip = new Ship();                 //Create instance of ship to be changed.
        for (Ship s : SQLDUMMY.getAllShips()) {
            tempShip = s;                           //Only one ship in list.
        }
        String newShipName = "Leopleurodon";
        String newShipClass = "Cruiser";
        int newShipGunCaliber = 152;
        int newShipLength = 200;
        int newShipNGuns = 16;

        assertTrue(shipHandling.changeShip(tempShip, newShipName, newShipClass, newShipGunCaliber, newShipLength, newShipNGuns));   //Change the ship fields.
    }
}
