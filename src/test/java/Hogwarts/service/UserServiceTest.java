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
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void getUsers() {
        int num = 6;
        assertEquals(num,userService.getUsers().size());
    }

    @Test
    public void login() {
        int id = 1;
        assertEquals(id,userService.login("13879517488","xtcxtcxtc").getId());
    }

    @Test
    public void signup() {
        userService.signup("fortest","test","TestAddress","12315");
        assertEquals(userService.findUserByphone("12315").getName(),"fortest");
    }

    @Test
    public void getUser() {
        assertEquals(userService.getUser(1).getName(),"xtc");
    }

    @Test
    public void saveUser() {
        User user = userService.getUser(1);
        user.setName("xtc");
        assertEquals("xtc",userService.saveUser(user).getName());
    }

    @Test
    public void getToken() {
        User user = userService.getUser(1);
        String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMzg3OTUxNzQ4OCJ9.u1zWp87n3XaIzaSNfeTSRGfPz7mM4Tg17gaMvSNe2iA";
        assertEquals(token,userService.getToken(user));
    }

    @Test
    public void findUserByphone() {
        User user = userService.findUserByphone("13879517488");
        assertEquals(user.getName(),"xtc");
    }

    @Test
    public void setUserRole() {
        User user = userService.getUser(1);
        userService.setUserRole(1,1);
        assertEquals(1,userService.getUser(1).getRole());

    }

    @Test
    public void setShow() {
        User user = userService.getUser(1);
        userService.setShow(1);
        userService.setShow(1);
        assertEquals(user.getIsShow(),userService.getUser(1).getIsShow());
    }

    @Test
    public void updateUserInfo() {
        User user = userService.getUser(1);
        userService.updateUserInfo(user);
        assertEquals(user.getName(),userService.getUser(1).getName());
    }

    @Test
    public void getOnesIcon() {
        assertEquals(userService.getOnesIcon(1),userService.getOnesIcon(1));
    }

    @Test
    public void getFriends() {
        assertEquals(userService.getFriends(1).size(),3);
    }

    @Test
    public void deleteFriends() {
        userService.deleteFriends(1,5);
        assertEquals(userService.getFriends(1).size(),3);
    }

    @Test
    public void applyFriend() {
        userService.applyFriend(3,1);
        User user = userService.getUser(1);
        assertEquals(user.getApply().size(),1);
    }

    @Test
    public void addFriend() {
        userService.addFriend(1,3);
        assertEquals(3,userService.getUser(1).getFriends().size());
    }
}
