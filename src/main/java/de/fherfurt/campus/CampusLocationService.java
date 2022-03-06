package de.fherfurt.campus;

import java.util.Set;

public interface CampusLocationService {

    CampusLocation findBy(Address address);

    Set<CampusLocation> findBy(String name);
}
