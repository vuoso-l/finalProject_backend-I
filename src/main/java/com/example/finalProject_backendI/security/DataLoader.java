package com.example.finalProject_backendI.security;

import com.example.finalProject_backendI.entity.login.UserRoles;
import com.example.finalProject_backendI.entity.login.User;
import com.example.finalProject_backendI.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final IUserRepository iUserRepository;

    @Autowired
    public DataLoader(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");
        iUserRepository.deleteAll();
        iUserRepository.save(new User("Lucas", "Lucas", "lucas@gmail.com", hashedPassword, UserRoles.ADMIN));
        iUserRepository.save(new User("Paula", "paula", "paula@gmail.com", hashedPassword2, UserRoles.USER));
    }
}
