package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void creat(){
        Item item = new Item();
        item.setName("노트북");
        item.setPrice(500000);
        item.setContent("삼성");

        Item newItem = itemRepository.save(item);
        Assert.notNull(newItem);

    }

    @Test
    public void read(){

    }
}
