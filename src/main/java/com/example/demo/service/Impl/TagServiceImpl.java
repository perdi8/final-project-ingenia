package com.example.demo.service.Impl;

import com.example.demo.dao.TagDAO.TagDAO;
import com.example.demo.model.Tag;
import com.example.demo.repository.TagRepository;
import com.example.demo.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Repository
public class TagServiceImpl implements TagService {
    private final Logger log = LoggerFactory.getLogger(TagServiceImpl.class);
    private final TagDAO tagDAO;
    TagRepository repository;


    public TagServiceImpl(TagDAO tagDAO, TagRepository repository) {
        this.tagDAO = tagDAO;
        this.repository = repository;
    }


    @Override
    public List<Tag> findAllFromEntityManager() {
        return this.tagDAO.findAllFromEntityManager();
    }

    @Override
    public Tag findByIdFromEntityManager(Long id) {
        return this.tagDAO.findByIdFromEntityManager(id);
    }

    @Override
    public List<Tag> findAllByAttributeFromEntityManager(String name) {
        return this.tagDAO.findAllByAttributeFromEntityManager(name);
    }


    @Override
    public Tag createTag(Tag tag) {
        log.info("createTag");
        if (ObjectUtils.isEmpty(tag))
            return null;
        return repository.save(tag);
    }

    @Override
    public Tag updateTag(Tag tag) {
        log.info("updateTag");
        if (ObjectUtils.isEmpty(tag))
            return null;
        return repository.save(tag);
    }
}
