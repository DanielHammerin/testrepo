package Testfolder;

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
        String shipName = "Victorium";
        String shipClass = "Battleship";
        int shipGunCaliber = 305;
        int shipLength = 320;
        int shipNGuns = 10;

        assertTrue(shipHandling.addShip(shipName, shipClass, shipGunCaliber, shipLength, shipNGuns));
    }
}
