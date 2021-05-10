package com.example.demo.service.Impl;

import com.example.demo.model.UserDetail;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

@Repository
public class RegisterServiceImpl implements RegisterService {
    RegisterRepository registerRepository;

    private final Logger log = LoggerFactory.getLogger(RegisterServiceImpl.class);

    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public UserDetail createUser(UserDetail userDetail) {
        log.info("createUSer");
        if (ObjectUtils.isEmpty(userDetail))
            return null;

        return registerRepository.save(userDetail);
    }
}
