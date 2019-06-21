package com.in28minutes.jpa.jpain10steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.jpa.jpain10steps.entity.User;
import com.in28minutes.jpa.jpain10steps.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner2 implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner2.class);
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        // Store users
        User user = new User("Jill", "Admin");
        userRepository.save(user);
        log.info("New user was created: " + user);
        
        // Find users
        Optional<User> userWithIdOne = userRepository.findById(1L);
        log.info("User is retrieved: " + userWithIdOne);
        
        // Find all users
        List<User> users = userRepository.findAll();
        log.info("All users: " + users);
    }

}
