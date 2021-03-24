package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
//@ToString(exclude = {"user", "item"})
public class OrderDetail {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String status;

        private LocalDateTime orderAt;

        private LocalDateTime arrivalDate;

        private Integer quantity;

        private BigDecimal totalPrice;



        private LocalDateTime createdAt;

        private String createdBy;

        private LocalDateTime updatedAt;

        private String updatedBy;

        //1 : N
        //order입장에서는 자신은 n이고 상대가 되는 userid는 1이다.
//      long였던 타입을 user타입으로도 바꿔줘야 한다.
//      변수명도 user이라고 변경
//        반드시 객체 명을 적어야 한다. 애가 알아서 userid를 찾아간다.

//        @ManyToOne
//        private User user;

//        N : 1

//        @ManyToOne
//        private Item item;
    }
