package de.fherfurt.campus;

public class CampusLocation {
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

    double latCoord;
    double longCoord;

    public CampusLocation(double latCoord, double longCoord) {
        this.latCoord = latCoord;
        this.longCoord = longCoord;
    }
}
