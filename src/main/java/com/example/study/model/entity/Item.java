package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private Integer price;

    private String content;

    private String brandName;



    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;



//    LAZY 타입과 EAGER 타입이 있다.
//    LAZY = 지연로딩(연관된 것만 로딩), EAGER = 1:1 즉시로딩(즉시 모든걸 다 로딩{한가지만 해도 모든걸 다 검색함.})

//    LAZY = SELECT * FROM item where id = ?

//    EAGER = item_id = order_detail.item_id
//    user_id = order_detail.user_id
//    where item.id = ?

    //    1:N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
