package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import com.example.study.model.enumclass.UserStatus;
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
        String account = "mandu";
        String password = "mandu1004";
        UserStatus status = UserStatus.REGISTERED;
        String email = "mandu@gmail.com";
        String phoneNumber = "010-5446-8789";
        LocalDateTime registeredAt = LocalDateTime.now();


        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);

        User u = User.builder().account(account).password(password).status(status).email(email).build();

        User newUser = userRepository.save(user);

        Assertions.assertNotNull(newUser);
        Assertions.assertEquals(newUser.getAccount(), account);

    }

    @Test
    @Transactional
    public void read() {

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1225-2582");


        if (user != null) {
            user.getOrderGroupList().stream().forEach(orderGroup -> {
                System.out.println("----------------주문묶음----------------");
                System.out.println("총금액 : " + orderGroup.getTotalPrice());
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("총수량 : " + orderGroup.getTotalQuantity());

                System.out.println("----------------주문상세----------------");
                orderGroup.getOrderDetailList().forEach(orderDetail -> {

                System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문 상품 : " + orderDetail.getItem().getName());
                System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getPartnerNumber());
                System.out.println("주문의 상태 : " + orderDetail.getStatus());
                System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());
                });
            });
        }
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
