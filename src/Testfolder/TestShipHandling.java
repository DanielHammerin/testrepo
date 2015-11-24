package Testfolder;

import Programfolder.Model.Member;
import Programfolder.Model.SQLDUMMY;
import Programfolder.Model.Ship;
import Programfolder.Model.ShipHandling;
import org.junit.*;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import java.util.ArrayList;



/**
 * Created by Daniel on 2015-11-19.
 */
public class TestShipHandling {

    private ShipHandling shipHandling;
    private SQLDUMMY sqldummy;
    private ArrayList<Member> mockedMemberList;
    private ArrayList<Ship> mockedShipList;


    @Before
    public void setUp() {
        sqldummy = mock(SQLDUMMY.class);
        mockedMemberList = new ArrayList<>();
        mockedShipList = new ArrayList<>();
        shipHandling = new ShipHandling(sqldummy);  //Instance shiphandling class with mocked SQLDUMMY

        Member m1 = new Member();
        m1.setMemberFirstName("Max");
        m1.setMemberLastName("W0w");
        m1.setMemberID("MW222");
        mockedMemberList.add(m1);

        Member m2 = new Member();
        m2.setMemberFirstName("Andrew");
        m2.setMemberLastName("Gower");
        m2.setMemberID("AG222");
        mockedMemberList.add(m2);

        Member m3 = new Member();
        m3.setMemberFirstName("Maximum");
        m3.setMemberLastName("Crispness");
        m3.setMemberID("MC999");
        mockedMemberList.add(m3);

        Ship s = new Ship();
        s.setShipName("qweqwe");
        s.setShipClass("big");
        s.setShipGunCaliber(300);
        s.setShipLength(200);
        s.setShipNGuns(30);
        mockedShipList.add(s);

    }

    @After
    public void tearDown() {
        mockedMemberList.clear();
        mockedShipList.clear();
    }

    @Test
    public void testAddShipReturnsTrue() throws Exception {
        when(sqldummy.getAllMembers()).thenReturn(mockedMemberList);

        Member tempMem = sqldummy.getAllMembers().get(0);

        String shipName = "Victorium";
        String shipClass = "Battleship";
        int shipGunCaliber = 305;
        int shipLength = 320;
        int shipNGuns = 10;

        assertTrue(shipHandling.addShip(tempMem, shipName, shipClass, shipGunCaliber, shipLength, shipNGuns));
    }

    @Test
    public void testChangeShipReturnsTrue() throws Exception {
        when(sqldummy.getAllMembers()).thenReturn(mockedMemberList);
        when(sqldummy.getAllShips()).thenReturn(mockedShipList);

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
        for (Ship s : sqldummy.getAllShips()) {
            tempShip = s;                           //Only one ship in list.
        }
        String newShipName = "Leopleurodon";
        String newShipClass = "Cruiser";
        int newShipGunCaliber = 152;
        int newShipLength = 200;
        int newShipNGuns = 16;

        assertTrue(shipHandling.changeShip(tempShip, newShipName, newShipClass, newShipGunCaliber, newShipLength, newShipNGuns));   //Change the ship fields.

    }

    @Test
    public void testDeleteShipReturnsTrue() throws Exception {
        when(sqldummy.getAllShips()).thenReturn(mockedShipList);

        Ship s = sqldummy.getAllShips().get(0);
        assertTrue(shipHandling.deleteShip(s));
    }

}
