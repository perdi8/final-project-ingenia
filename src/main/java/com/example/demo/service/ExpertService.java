package com.example.demo.service;

import com.example.demo.model.Expert;

import java.util.List;

public interface ExpertService {

    List<Expert> findAllFromEntityManager();

    Expert findByIdFromEntityManager(Long id);

    List<Expert> findAllByAttributeFromEntityManager(String name);

    Expert createExpert(Expert expert);

    Expert updateExpert(Expert expert);
}
