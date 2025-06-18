package com.udemy.projetospring.config;

import com.udemy.projetospring.entities.User;
import com.udemy.projetospring.repositories.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author carol
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "988888888");
        User u2 = new User(null, "Alex Green", "977777777");
        
        userRepository.saveAll(Arrays.asList(u1, u2));
    }

}
