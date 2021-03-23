package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    // Dependency Injection
    // 내가 알아서 객체 관리 할게~
    @Autowired
    private UserRepository userRepository;


    @Test
    public void create(){

        User user = new User();
        //        객체생성.
        //        String sql = insert into user (%s, %s, %d) value (account, email, age);


        user.setAccount("magenta");
        user.setEmail("magenta@gmail.com");
        user.setPhoneNumber("010-5569-4535");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);


    }
    @Test
    public void read(){

        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(seleteUser -> {
            System.out.println("user : " + seleteUser);
        });
    }
    public void update(){

    }
    public void delete(){

    }

}
