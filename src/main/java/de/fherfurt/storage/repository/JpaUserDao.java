package de.fherfurt.storage.repository;

import de.fherfurt.model.Comment;
import de.fherfurt.model.Post;
import de.fherfurt.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

class JpaUserDao extends JpaGenericDao<User> implements UserDao{

    public JpaUserDao( EntityManager em)
    {
        super(User.class, em);
    }

}
