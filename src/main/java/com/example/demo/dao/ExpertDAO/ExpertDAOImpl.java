package com.example.demo.dao.ExpertDAO;

import com.example.demo.model.Expert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ExpertDAOImpl implements ExpertDAO{

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<Expert> findAllFromEntityManager() {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);
        criteria.select(root);

        return manager.createQuery(criteria).getResultList();
    }

    @Override
    public Expert findByIdFromEntityManager(Long id){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);

        criteria.select(root);

        criteria.where(builder.equal(root.get("id"), id));

        return manager.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Expert> findAllByAttributeFromEntityManager(String name) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);
        criteria.select(root);

        criteria.where(builder.equal(root.get("name"), name));

        return manager.createQuery(criteria).getResultList();
    }

}

