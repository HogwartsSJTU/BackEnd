package Hogwarts.controller;

import Hogwarts.entity.Message;
import Hogwarts.entity.User;
import Hogwarts.security.ManagerLoginToken;
import Hogwarts.security.PassToken;
import Hogwarts.security.UserLoginToken;
import Hogwarts.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    //管理员获得所有用户
    @ManagerLoginToken
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @UserLoginToken
    @PostMapping("/updateUserInfo")
    public void updateUserInfo(@RequestParam("userId") int userId, @RequestParam("name") String name, @RequestParam("gender") String gender,
                               @RequestParam("age") int age, @RequestParam("address") String address, @RequestParam("phone") String phone,
                               @RequestParam("description") String description, @RequestParam("image") String image
                               )
    {
        userService.updateUserInfo(userId,name,gender,age,address,phone,description,image);
    }

    //登录
    @PassToken
    @PostMapping("/login")
    public Object login(@RequestParam("email") String email,@RequestParam("password") String password){
        System.out.println(email);

        System.out.println(password);
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findUserByemail(email);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(password)){
                jsonObject.put("message","登录失败,密码错误");
            }
            else {
                String token = userService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
            }
            return jsonObject;
        }
    }

    //注册
    @PassToken
    @PostMapping("/signup")
    public User signup(@RequestParam("name") String name, @RequestParam("password") String password,
                       @RequestParam("address") String address, @RequestParam("phone") String phone){
        return userService.signup(name,password,address,phone);
    }

    //通过id获得user
    @UserLoginToken
    @GetMapping("/getUser")
    public User getUser(@RequestParam("id") int id){return userService.getUser(id);}

    //保存user信息
    @UserLoginToken
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){return userService.saveUser(user);}

    @ManagerLoginToken
    @GetMapping("setUserRole")
    public void setUserRole(@RequestParam("userId") int userId,@RequestParam("role") int role){
        userService.setUserRole(userId,role);
    }

    @UserLoginToken
    @PostMapping("/setShow")
    public void setShow(@RequestParam("userId") int userId){userService.setShow(userId);}

    @PassToken
    @GetMapping("/getOnesIcon")
    public List<String> getOnesIcon(@RequestParam("userId") int userId){return userService.getOnesIcon(userId);}

    @PassToken
    @GetMapping("/getFriends")
    public List<User> getFriends(@RequestParam("userId") int userId) {
        return userService.getFriends(userId);
    }

    @PassToken
    @PostMapping("/deleteFriends")
    public void deleteFriends(@RequestParam("userId") int userId, @RequestBody List<User> li) {
        userService.deleteFriends(userId,li);
    }

//    @PassToken
//    @PostMapping("/applyFriend")
//    public void applyFriend(@RequestParam("userId") int userId,@RequestParam("friendId") int friendId) {
//        userService.
//    }
}
