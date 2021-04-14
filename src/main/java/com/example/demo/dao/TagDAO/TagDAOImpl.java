package com.example.demo.dao.TagDAO;

import com.example.demo.model.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TagDAOImpl implements TagDAO {

    @PersistenceContext
    private EntityManager manager;



    @Override
    public List<Tag> findAllFromEntityManager() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);
        criteria.select(root);

        return manager.createQuery(criteria).getResultList();
    }

    @Override
    public Tag findByIdFromEntityManager(Long id){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);

        criteria.select(root);

        criteria.where(builder.equal(root.get("id"), id));

        return manager.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Tag> findAllByAttributeFromEntityManager(String name) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);
        criteria.select(root);

        criteria.where(builder.like(root.get("name"), "%" + name + "%"));

        return manager.createQuery(criteria).getResultList();
    }


}
