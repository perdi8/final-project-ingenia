package com.example.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// Para poder inyectarlo despues
@Service
public class UserDetailServices implements UserDetailsService {

    // Implementacion de metodos

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retorna un nuevo usuario de spring security donde ponemos nuestro usuario, el array list
        // se utiliza para poner los tipos de roles que tendra el usuario
        // el codificador de la contraseña es dentro de {} poner noop
        return new User("miguel", "{noop}ingenia", new ArrayList<>());
    }
}
