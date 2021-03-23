package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity // == table
//@Table(name = "user")

//@Table이 존재하지만 User와 db의 table이름인 user와 같기 때문에 쓸 필요 없다.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql이기 때문에 identity로 한다.
    private Long id;




//    @Column(name = "account")
    private String account;

    private String email;

    private String phoneNumber;
//    이거 phone_number로 할 필요 없음 자바가 알아서 바꿔줌.


    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}
