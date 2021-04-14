package com.example.demo.dao.ExpertDAO;

import com.example.demo.model.Expert;

import java.util.List;

public interface ExpertDAO {

    List<Expert> findAllFromEntityManager();

    Expert findByIdFromEntityManager(Long id);

    List<Expert> findAllByAttributeFromEntityManager(String name);
}
