package de.fherfurt.storage.repository;

import de.fherfurt.model.Post;

import javax.persistence.EntityManager;

class JpaPostDao extends JpaGenericDao<Post> implements PostDao {

    public JpaPostDao(EntityManager em)
    {
        super(Post.class, em);
    }

}
