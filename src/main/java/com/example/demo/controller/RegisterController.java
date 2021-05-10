package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://final-project-ingenia-angular.vercel.app", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class RegisterController {

    private final Logger log = LoggerFactory.getLogger(RegisterController.class);

    private final RegisterService registerService;
    public final RegisterRepository registerRepository;

    public RegisterController(RegisterService registerService, RegisterRepository registerRepository) {
        this.registerService = registerService;
        this.registerRepository = registerRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<User> createExpert(@RequestBody User user) throws URISyntaxException {
        log.debug("REST request to create an User: {} ", user);
        if (user.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


        User userDB = registerService.createUser(user);
        return ResponseEntity
                .created(new URI("/api/register" + userDB.getId()))
                .body(userDB);
    }
}
