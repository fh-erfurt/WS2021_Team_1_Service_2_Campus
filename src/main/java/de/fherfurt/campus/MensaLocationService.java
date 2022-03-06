package de.fherfurt.campus;

import de.fherfurt.campus.Address;

import de.fherfurt.campus.MensaLocation;

import java.util.Set;

public interface MensaLocationService {


    MensaLocation findBy(Address address);

    Set<MensaLocation> findBy(String name);
}
