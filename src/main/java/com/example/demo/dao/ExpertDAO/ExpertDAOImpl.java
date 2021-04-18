package com.example.demo.dao.ExpertDAO;

import com.example.demo.dao.TagDAO.TagDAO;
import com.example.demo.model.Expert;
import com.example.demo.model.Tag;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

@Repository
public class ExpertDAOImpl implements ExpertDAO{

    @PersistenceContext
    private EntityManager manager;


    @Autowired
    private TagDAO tagDAO;

//    @Autowired
//    private Expert Expert_;
//
//    @Autowired
//    private Tag Tag_;



    @Override
    public List<Expert> findAllFromEntityManager(Integer limite, Integer pagina) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);
        criteria.select(root);

        Query query = manager.createQuery(criteria);

        query.setMaxResults(limite); // size
        query.setFirstResult(pagina); // pagination

        return query.getResultList();
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
    public List<Expert> findAllByTagExperts(Long tagId, Integer limite, Integer pagina) {


//         CriteriaBuilder cb = manager.getCriteriaBuilder();
//         CriteriaQuery<Expert> query = cb.createQuery(Expert.class);
//         Root<Expert> expertRoot = query.from(Expert.class);
//         query.select(expertRoot);
//         TypedQuery<Expert> typedQuery = manager.createQuery(query);
//         List<Expert> resultList = typedQuery.getResultList();

        Optional<Tag> tagOpt = tagDAO.findByIdFromEntityManager(tagId);
        if (tagId != null) {

            return tagOpt.get().getExperts();
        }


        return new ArrayList<>();

    }
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//        CriteriaQuery<Expert> query = builder.createQuery(Expert.class);
//        Root<Expert> root = query.from(Expert.class);
//
//        ListJoin<Expert, Tag> tags = root.get(Expert_.tags);
//
//        query.select(root)
//                .where(builder.equal(tags.get(Tag_.id), tagId))
//                .distinct(true);
//
//        TypedQuery<Expert> typedQuery = em.createQuery(query);
//        typedQuery.getResultList();
//
//
//        return typedQuery.getResultList();

//            return tag;
//        }



    @Override
    public List<Expert> findAllNombreExperts(String nombre, Integer limite, Integer pagina) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);
        criteria.select(root);

        criteria.where(builder.equal(root.get("nombre"), nombre));

        Query query = manager.createQuery(criteria);

        query.setMaxResults(limite); // size
        query.setFirstResult(pagina); // pagination

        return query.getResultList();
    }

    @Override
    public List<Expert> findAllModalidadExperts(String modalidad, Integer limite, Integer pagina) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);
        criteria.select(root);

        criteria.where(builder.equal(root.get("modalidad"), modalidad));

        Query query = manager.createQuery(criteria);

        query.setMaxResults(limite); // size
        query.setFirstResult(pagina); // pagination

        return query.getResultList();
    }

    @Override
    public List<Expert> findAllEstadoExperts(String estado, Integer limite, Integer pagina) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);
        criteria.select(root);

        criteria.where(builder.equal(root.get("estado"), estado));

        Query query = manager.createQuery(criteria);

        query.setMaxResults(limite); // size
        query.setFirstResult(pagina); // pagination

        return query.getResultList();
    }

}

