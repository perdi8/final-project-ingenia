package com.example.demo.service.Impl;


import com.example.demo.model.User;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.service.RegisterService;
import org.apache.commons.codec.digest.DigestUtils;
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


        Optional<String> email = Optional.ofNullable(user.getEmail());
        Optional<User> emailDB = registerRepository.findByEmail(email);
         Optional<Object> db = emailDB.map(a -> {
            String ala =  a.getEmail();
             return ala;
         });

        String md5Hex = DigestUtils.md5Hex(user.getPassword()).toUpperCase();
        user.setPassword(md5Hex);
        System.out.println("~~~~~~~~~~$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  DB " + db  ) ;
        System.out.println("~~~~~~~~~~$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ USER "  + email) ;

        if (email.equals(db))  {
            return null;
        }
        return registerRepository.save(user);
    }
}
