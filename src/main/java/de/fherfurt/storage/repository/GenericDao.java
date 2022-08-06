package de.fherfurt.storage.repository;

import de.fherfurt.core.entity.AbstractDatabaseEntity;

import java.util.Collection;
import java.util.List;

/*
    Common Interface for all of our Dao classes

    Completely hides all the JPA/Database related stuff.

    Always use this interface as reference type wherever you
    need to use a DAO!
 */
interface GenericDao<T extends AbstractDatabaseEntity>
{
    T findById( Long id );
    Collection<T> findAll();

    boolean create( T entity );
    boolean createAll( Collection<T> newEntities );

    T update( T entity );

    boolean delete( Long id );
    boolean delete( T entity );
    boolean delete( List<T> entries );
}