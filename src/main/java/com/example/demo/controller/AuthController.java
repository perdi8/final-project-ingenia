package com.example.demo.controller;


import com.example.demo.config.AuthenticationRequest;
import com.example.demo.config.AuthenticationResponse;
import com.example.demo.security.JWTUtil;
import com.example.demo.service.UserDetailServicesImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@CrossOrigin(origins = "https://final-project-ingenia-angular.vercel.app", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServicesImpl userDetailServicesImpl;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {

        String md5Hex = DigestUtils.md5Hex(request.getPassword()).toUpperCase();
        request.setPassword(md5Hex);

        System.out.println(md5Hex);

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

            UserDetails userDetails = userDetailServicesImpl.loadUserByUsername(request.getEmail());
            System.out.println(userDetails);
            String jwt = jwtUtil.generateToken(userDetails);

            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);

    }
}
