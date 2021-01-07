package Hogwarts.service;

import Hogwarts.HogwartsApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {
    @Autowired
    CommentService commentService;

    @Test
    public void create() {
        assertEquals(commentService.create(1,2,"test",70).getText(),"test");
    }
}
