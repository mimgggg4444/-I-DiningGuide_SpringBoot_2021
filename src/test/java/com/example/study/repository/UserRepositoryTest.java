package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Partner;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        String account = "minki";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1225-2582";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assertions.assertNotNull(newUser);
        Assertions.assertEquals(newUser.getAccount(), account);

    }

    @Test
    @Transactional
    public void read(){
    }

    @Test
    @Transactional
    public void update(){
    }

    @Test
    @Transactional
    public void delete() {
    }


}
