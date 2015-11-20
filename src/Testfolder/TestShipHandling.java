package Testfolder;

import Programfolder.Member;
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
        Member tempMem = new Member();
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
}
