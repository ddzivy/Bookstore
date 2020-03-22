package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.Bookstore.controller.BookController;


/**
 * Testing that the context is creating controller
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {

    @Autowired
    private BookController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }	
}



