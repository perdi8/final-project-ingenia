package com.example.demo.service.Impl;


import com.example.demo.model.User;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.service.RegisterService;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Repository
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterRepository registerRepository;

    private final Logger log = LoggerFactory.getLogger(RegisterServiceImpl.class);

    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public User createUser(User user) {
        log.info("createUSer");
        if (ObjectUtils.isEmpty(user))
            return null;


        String email = user.getEmail();
        Optional<User> emailDB = registerRepository.findByEmail(email);


        System.out.println("~~~~~~~~~~$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ "  + emailDB) ;

        String userPassword = user.getPassword();
        user.setPassword(BCrypt.hashpw(userPassword, BCrypt.gensalt()));

        return registerRepository.save(user);
    }
}
