package de.fherfurt.storage.repository;

import de.fherfurt.model.Ooser;

import java.util.List;

public interface OoserRepository {

    List<Ooser> getAllOosers();

    Ooser getOoser(long ooserId);
    boolean createOoser(Ooser ooser);
    boolean updateOoser(Ooser ooser);
    boolean deleteOoser(long ooserId);
}
