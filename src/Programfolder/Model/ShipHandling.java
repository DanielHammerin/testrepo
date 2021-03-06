package Programfolder.Model;

/**
 * Created by Daniel on 2015-11-20.
 */
public class ShipHandling {

    private SQLDUMMY sql;

    public ShipHandling(SQLDUMMY sqlIn) {
        sql = sqlIn;
    }

    public boolean addShip(Member member, String shipName, String shipClass, int shipGunCaliber, int shipLength, int shipNGuns) {
        try {
            Ship newShip = new Ship();
            newShip.setOwner(member);
            newShip.setShipName(shipName);
            newShip.setShipClass(shipClass);
            newShip.setShipGunCaliber(shipGunCaliber);
            newShip.setShipNGuns(shipNGuns);
            newShip.setShipLength(shipLength);
            sql.saveShip(newShip);
            return true;
        }
        catch (Exception e) {
            System.out.println("Error1.");
        }
        return false;
    }

    public boolean changeShip(Ship tempShip, String newShipName, String newShipClass, int newShipGunCaliber, int newShipLength, int newShipNGuns) {
        try {
            for (Ship s : sql.getAllShips()) {
                if (s.equals(tempShip)) {
                    s.setShipName(newShipName);
                    s.setShipClass(newShipClass);
                    s.setShipGunCaliber(newShipGunCaliber);
                    s.setShipLength(newShipLength);
                    s.setShipNGuns(newShipNGuns);
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

    public boolean deleteShip(Ship s) {
        try {
            for (Ship ship : sql.getAllShips()) {
                if (ship.equals(s)) {
                    sql.deleteShip(ship);
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error3.");
        }
        return false;
    }
}
