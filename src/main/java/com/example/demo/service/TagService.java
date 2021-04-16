package com.example.demo.service;

import com.example.demo.model.Tag;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface TagService {

    List<Tag> findAllFromEntityManager();

    Optional<Tag> findByIdFromEntityManager(Long id);

    List<Tag> findAllByAttributeFromEntityManager(String name);

    List<Tag> findAll(Integer limite, Integer pagina);

    List<Tag> findAllFilterNombre(String nombre , Integer limite, Integer pagina);


    Tag createTag(Tag tag);

    Tag updateTag(Tag tag);

}

