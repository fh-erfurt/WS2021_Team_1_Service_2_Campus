package de.fherfurt.storage.repository;

import de.fherfurt.model.Ooser;

import javax.persistence.EntityManager;

class JpaOoserDao extends JpaGenericDao<Ooser> implements OoserDao {

    public JpaOoserDao(EntityManager em)
    {
        super(Ooser.class, em);
    }

}
