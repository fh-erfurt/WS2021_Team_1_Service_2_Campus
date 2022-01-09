package de.fherfurt.campus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Search {

    private final Map<String, CampusLocation> locations = new HashMap<>(){{
        put("Altonaer Straße", new CampusLocation(2.1,1.1));
        put("Steinplatz 2", new CampusLocation(2.2,1.2));
        put("Leipziger Straße 77", new CampusLocation(2.2,1.2));
        put("Schlüterstraße 1", new CampusLocation(2.2,1.2));
        put("Campus nicht gefunden", new CampusLocation(0,0));
    }};


    public CampusLocation findByStreet(Campus street) {
        switch (street.getStreet()) {
            case "Altonaer Straße":
                return locations.get("Altonaer Straße");
            case "Steinplatz 2":
                return locations.get("Steinplatz 2");
            case "Leipziger Straße 77":
                return locations.get("Leipziger Straße 77");
            case "Schlüterstraße 1":
                return locations.get("Schlüterstraße 1");
            default:
                return locations.get("Campus nicht gefunden");
        }}



        public CampusLocation findByName(String name) {

            CampusLocation res = new CampusLocation(0,0);
            //For every entry in entry set do compare to the list
            for (Map.Entry<String, CampusLocation> entry : locations.entrySet()) {
                if (entry.getKey().toLowerCase().contains(name.toLowerCase())) {
                    res = entry.getValue();
                }
            }
            return res;
    }
}



