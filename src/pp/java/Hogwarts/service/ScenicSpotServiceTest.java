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
class ScenicSpotServiceTest {
    @Autowired
    ScenicSpotService scenicSpotService;

    @Test
    public void create() {
        assertEquals(scenicSpotService.create("test","testaddress",141.1,143.5,"no",20).getHot(),20);
    }
}
