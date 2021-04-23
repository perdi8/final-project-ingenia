package com.example.demo.dao.TagDAO;

import com.example.demo.model.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

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
    public Optional<Tag> findByIdFromEntityManager(Long id){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag>root = criteria.from(Tag.class);

        criteria.select(root);

        criteria.where(builder.equal(root.get("id"), id));

        return Optional.of(manager.createQuery(criteria).getSingleResult());
    }

    @Override
    public List<Tag> findAllByAttributeFromEntityManager(String nombre) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);
        criteria.select(root);

        criteria.where(builder.like(root.get("nombre"), "%" + nombre + "%"));

        return manager.createQuery(criteria).getResultList();
    }

    @Override
    public List<Tag> findAll(Integer limite, Integer pagina) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);
        criteria.select(root);

       Query query = manager.createQuery(criteria);

        query.setMaxResults(limite); // size
        query.setFirstResult(pagina); // pagination

        List<Tag> tags = query.getResultList();
        System.out.println(tags);

        return tags;
    }


    @Override
    public List<Tag> findAllFilterNombre(String nombre, Integer limite, Integer pagina) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);
        criteria.select(root);

        criteria.where(builder.like(root.get("nombre"),  "%" + nombre + "%"));

        Query query = manager.createQuery(criteria);

        query.setMaxResults(limite); // size
        query.setFirstResult(pagina); // pagination

        List<Tag> tags = query.getResultList();
        System.out.println(tags);

        return tags;
    }



}
