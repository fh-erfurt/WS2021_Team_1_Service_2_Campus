package de.fherfurt.campus;

import java.util.HashMap;
import java.util.Map;
public class Search {

    private final Map<String, CampusLocation> locations = new HashMap<>(){{
        put("Altonaer Straße", new CampusLocation(2.1,1.1));
        put("Steinplatz 2", new CampusLocation(2.2,1.2));
        put("Leipziger Strße 77", new CampusLocation(2.2,1.2));
        put("Schlüterstraße 1", new CampusLocation(2.2,1.2));
    }};

    public int findByName(String input)
    {
        return 0;
    }

    public CampusLocation findByStreet(Address street) {
        switch (street.getStreet()) {
            case "Altonaer Straße":
                return locations.get("Campus Altonaer Straße");
            case "Steinplatz 2":
                return locations.get("CampusSteinplatz 2");
            case "Leipziger Strße 77":
                return locations.get("Campus Leipziger Strße 77");
            case "Schlüterstraße 1":
                return locations.get("Campus Schlüterstraße 1");
            default:
                return locations.get("Campus");
        }
    }
}