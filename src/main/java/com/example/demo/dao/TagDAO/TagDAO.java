package com.example.demo.dao.TagDAO;

import com.example.demo.model.Tag;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface TagDAO {

    List<Tag> findAllFromEntityManager();

    Optional<Tag> findByIdFromEntityManager(Long id);

    List<Tag> findAllByAttributeFromEntityManager(String name);

    List<Tag> findAll(Integer limite, Integer pagina);

    List<Tag> findAllFilterNombre(String nombre, Integer limite, Integer pagina);

}
