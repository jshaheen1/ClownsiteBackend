package com.quinnox.training.clowns.clownspef;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.quinnox.training.clowns.lionspef.Lion;
import com.quinnox.training.clowns.lionspef.LionRepository;
import com.quinnox.training.clowns.userspef.Role;
import com.quinnox.training.clowns.userspef.UserRepository;
import com.quinnox.training.clowns.userspef.Users;


@Configuration
public class ClownConfig {
	
	@Autowired
	PasswordEncoder encoder;

    @Bean
    CommandLineRunner commandLineRunner (LionRepository lionRepository, 
        ClownRepository clownRepository, UserRepository userRepository ) {
        return args -> {
            Clown chuckles = new Clown(10, "Chuckles", "Juggling");
            Clown caesar = new Clown(14, "Caesar", "Magic");
            Lion alex = new Lion("Alex", 100);
            Users me = new Users("user", encoder.encode("pass"), Role.ME);
            List<Clown> helper = new ArrayList<Clown>();
            helper.add(chuckles);
            helper.add(caesar);
            clownRepository.saveAll(helper);
            lionRepository.save(alex);
            userRepository.save(me);
        };
    }   
}
