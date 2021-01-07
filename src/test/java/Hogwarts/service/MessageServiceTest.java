package Hogwarts.service;

import Hogwarts.HogwartsApplicationTest;
import Hogwarts.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageServiceTest {
    @Autowired
    MessageService messageService;

    @Test
    public void getMessages() {
        assertEquals(messageService.getMessages(1,2).size(),0);
    }
}
