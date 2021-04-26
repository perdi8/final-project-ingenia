package com.example.demo.controller;


import com.example.demo.config.AuthenticationRequest;
import com.example.demo.config.AuthenticationResponse;
import com.example.demo.security.JWTUtil;
import com.example.demo.service.UserDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServices userDetailServices;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {



            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            UserDetails userDetails = userDetailServices.loadUserByUsername(request.getUsername());
            System.out.println(userDetails);
            String jwt = jwtUtil.generateToken(userDetails);

            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);



    }
}
