package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import javax.transaction.Transactional;
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
        user.setCreatedBy("guest");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);


    }

    @Test
    @Transactional
    public void read(){     //@RequestParam Long id (매겨변수 안의 값을 이렇게 만들어서 들어온 값을 검색 할 수 있다.) 당연 return 값은 User로 바꿔줘야 한다.
        Optional<User> user = userRepository.findByAccount("magenta");


//        select * from user where id =?

        user.ifPresent(selectUser -> {
//            이렇게 하면 list형태로 반환된다.
            selectUser.getOrderDetailList().stream().forEach(detail ->{
                Item item = detail.getItem();
                System.out.println(detail.getItem());
            });
        });
//        return user.get();    (만약 위에 저렇게 했다면)
    }

    @Test
    @Transactional
    public void update(){

        Optional<User> user = userRepository.findById(4L);
        user.ifPresent(selectUser -> {
            selectUser.setAccount("minki");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("minki");

            userRepository.save(selectUser);
//            위의 create에서도 이걸 사용했는데 spring이 어떻게 아느냐?
//            findById(2L);로 알 수 있다. 하지만
//            selectUser.setId(3L);로 하면 id3번이 바뀌게 된다.
        });
    }

//    @DeleteMapping("/api/user")
//    public void delete(@RequestParam Long id){
//    }
//    원래는 이렇게 진행함.

    @Test
    @Transactional
    public void delete(){

        Optional<User> user = userRepository.findById(1L);
//          3이 반드시 존재해야 하기 때문에
//        Assert.isTrue(user.isPresent());


        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);

            //delete는 지우기 때문에 반환형이 따로 필요하지 않다.
//            여기서 한번 삭제되었기 때문에 아래에서 어떻게 나오는지 확인해보자.
        });

        Optional<User> deleteUser = userRepository.findById(1L);


        if (deleteUser.isPresent()){
            System.out.println("데이터 존재: " + deleteUser.get());
        }else{
            System.out.println("데이터가 삭제되어 아무것도 없습니다.");
        }
    }


}
