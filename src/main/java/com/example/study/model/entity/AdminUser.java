package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    private String status; // 계정의 상태를 알 수 있다.

    private String role;    // 계정의 권한을 알 수 있다.

    private LocalDateTime lastLoginAt;

    private String passwordUpdatedAt;

    private int loginFailCount;

    private LocalDateTime registeredAt; //가입일자

    private LocalDateTime unregisteredAt;   //해지일자



    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;


}
