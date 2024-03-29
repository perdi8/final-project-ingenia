package com.example.demo.service.Impl;

import com.example.demo.dao.ExpertDAO.ExpertDAO;
import com.example.demo.dao.ExpertDAO.ExpertDAOImpl;
import com.example.demo.model.Expert;
import com.example.demo.model.Tag;
import com.example.demo.repository.ExpertRepository;
import com.example.demo.service.ExpertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService {

    private final Logger log = LoggerFactory.getLogger(ExpertServiceImpl.class);

    private final ExpertDAOImpl expertDAOImpl;
    private final ExpertDAO expertDAO;

    ExpertRepository expertRepository;

    public ExpertServiceImpl(ExpertDAOImpl expertDAOImpl, ExpertDAO expertDAO, ExpertRepository expertRepository) {
        this.expertDAOImpl = expertDAOImpl;
        this.expertDAO = expertDAO;
        this.expertRepository = expertRepository;
    }


    @Override
    public List<Expert> findAllFromEntityManager(Integer limite, Integer pagina) {
        return this.expertDAO.findAllFromEntityManager(limite, pagina);
    }

    @Override
    public Expert findByIdFromEntityManager(Long id) {
        return this.expertDAO.findByIdFromEntityManager(id);
    }



    @Override
    public List<Expert> findAllByTagExperts(Long tagId, Integer limite, Integer pagina) {
        return this.expertDAO.findAllByTagExperts(tagId, limite, pagina);
    }

    @Override
    public List<Expert> findAllNombreExperts(String nombre, Integer limite, Integer pagina) {
        return this.expertDAO.findAllNombreExperts(nombre, limite, pagina);
    }

    @Override
    public List<Expert> findAllModalidadExperts(String modalidad, Integer limite, Integer pagina) {
        return this.expertDAO.findAllModalidadExperts(modalidad, limite, pagina);
    }

    @Override
    public List<Expert> findAllEstadoExperts(String estado, Integer limite, Integer pagina) {
        return this.expertDAO.findAllEstadoExperts(estado, limite, pagina);
    }


    @Override
    public Expert createExpert(Expert expert) {
        log.info("createUSer");
        if (ObjectUtils.isEmpty(expert))
            return null;

        return expertRepository.save(expert);
    }


    @Override
    public Expert updateExpert(Expert expert) {
        log.info("updateUser");
        if (ObjectUtils.isEmpty(expert))
            return null;
        return expertRepository.save(expert);
    }
}
