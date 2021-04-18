package com.example.demo.service;

import com.example.demo.model.Expert;
import com.example.demo.model.Tag;

import java.util.List;

public interface ExpertService {

    List<Expert> findAllFromEntityManager(Integer limite, Integer pagina);

    Expert findByIdFromEntityManager(Long id);

    List<Expert> findAllByTagExperts(Long tagId, Integer limite, Integer pagina);

    List<Expert>findAllNombreExperts(String nombre, Integer limite,Integer pagina);

    List<Expert>findAllModalidadExperts(String modalidad, Integer limite,Integer pagina);

    List<Expert>findAllEstadoExperts(String estado, Integer limite, Integer pagina);

    Expert createExpert(Expert expert);

    Expert updateExpert(Expert expert);
}
