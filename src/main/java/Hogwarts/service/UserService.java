package Hogwarts.service;

import Hogwarts.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User login(String phone, String password);
    User signup(String name,String password,String address,String phone);
    User getUser(int id);
    User saveUser(User user);
    String getToken(User user);
    User findUserByphone(String phone);
    void setUserRole(int userId,int role);
    void setShow(int userId);
    void updateUserInfo(int id, String name, String gender, int age, String address, String phone, String description,String image);
    List<String> getOnesIcon(int userId);
    List<User> getFriends(int userId);
    void deleteFriends(int userId, List<User> li);
}
