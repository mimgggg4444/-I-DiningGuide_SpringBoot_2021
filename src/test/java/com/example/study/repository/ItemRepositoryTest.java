package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();

         item.setName("laptop");
        item.setPrice(500000);
        item.setContent("삼성");

        Item newItem = itemRepository.save(item);

        Assert.notNull(newItem);

    }

    @Test
    public void read(){

        Long id = 1L;
        Optional <Item> item = itemRepository.findById(id);

        Assert.isTrue(item.isPresent());


    }
}
