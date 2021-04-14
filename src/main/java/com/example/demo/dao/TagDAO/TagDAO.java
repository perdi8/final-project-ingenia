package com.example.demo.dao.TagDAO;

import com.example.demo.model.Tag;

import java.util.List;

public interface TagDAO {

    List<Tag> findAllFromEntityManager();

    Tag findByIdFromEntityManager(Long id);

    List<Tag> findAllByAttributeFromEntityManager(String name);
}
