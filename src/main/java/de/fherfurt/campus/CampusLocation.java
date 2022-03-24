package de.fherfurt.campus;
/**
 *
 * @author Andreas Lemke & Justus Hose
 */
public class CampusLocation {
    private double latCoord;
    private double longCoord;

    public double getLatCoord() {
        return latCoord;
    }

    public void setLatCoord(double latCoord) {
        this.latCoord = latCoord;
    }

    public double getLongCoord() {
        return longCoord;
    }

    public void setLongCoord(double longCoord) {
        this.longCoord = longCoord;
    }

    public CampusLocation(double latCoord, double longCoord) {
        this.latCoord = latCoord;
        this.longCoord = longCoord;
    }
}
