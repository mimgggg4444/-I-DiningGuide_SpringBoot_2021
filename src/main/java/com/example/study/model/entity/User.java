package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity // == table
//@Table이 존재하지만 User와 db의 table이름인 user와 같기 때문에 쓸 필요 없다.
public class User {


    private Long id;

    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql이기 때문에 identity로 한다.
    public Long getId() {
        return id;
    }

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
