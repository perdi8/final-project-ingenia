package com.example.demo.service;

import com.example.demo.model.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAllFromEntityManager();

    Tag findByIdFromEntityManager(Long id);

    List<Tag> findAllByAttributeFromEntityManager(String name);

    Tag createTag(Tag tag);

    Tag updateTag(Tag tag);

}

