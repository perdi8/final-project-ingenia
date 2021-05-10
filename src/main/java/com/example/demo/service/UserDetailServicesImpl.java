package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

// Para poder inyectarlo despues
@Service
public class UserDetailServicesImpl implements UserDetailsService {

    @Autowired
    RegisterRepository registerRepository;
    // Implementacion de metodos

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Retorna un nuevo usuario de spring security donde ponemos nuestro usuario, el array list
        // se utiliza para poner los tipos de roles que tendra el usuario
        // el codificador de la contraseña es dentro de {} poner noop

        User user = registerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " +  email));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), "{noop}" + user.getPassword() ,new ArrayList<>());

    }
}
