package Hogwarts.serviceimpl;

import Hogwarts.entity.User;
import Hogwarts.repository.UserRepository;
import Hogwarts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<String> getOnesIcon(int userId){
      List<String> res = new ArrayList<>();
      User user = userRepository.findById(userId).get();
      res.add(user.getName());
      res.add(user.getIcon());
      return res;
    };

    @Override
    public void updateUserInfo(int userId, String name, String gender, int age, String address, String phone, String description,String icon){
        User user = userRepository.findById(userId).get();
        user.setName(name);
        user.setGender(gender);
        user.setAge(age);
        user.setAddress(address);
        user.setPhone(phone);
        user.setDescription(description);
        user.setIcon(icon);
        user.setRole(-2);
        userRepository.save(user);
    };

    @Override
    public User findUserByemail(String email){
        return userRepository.findUserByemail(email);
    }

    @Override
    public void setShow(int userId){
        User user = userRepository.findById(userId).get();
        user.setIsShow(user.getIsShow()==1?0:1);
        userRepository.save(user);
    }

    @Override
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getEmail())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return "Bearer "+token;
    }

    @Override
    public List<User> getUsers() {
        List<User> list;
        list = userRepository.findAll();
        return list;
    }

    @Override
    public User getUser(int id){
        if(userRepository.findById(id).isPresent())
        {
            User user = userRepository.findById(id).get();
            user.setPassword("已隐藏");
            return user;
        }
        else return null;
    }

    @Override
    public User login(String email, String password){
        User user = userRepository.login(email,password);
        return user;
    }

    @Override
    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public User signup(String name,String password,String email,String address,String phone){
        User user = new User();
        List<User> list;
        list = userRepository.findAll();
        int maxIndex = list.size()-1;
        int max = 1 + list.get(maxIndex).getId();
        user.setId(max);
        user.setRole(0);
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setAddress(address);
        user.setPhone(phone);
        user.setIsShow(1);
        user.setAge(20);
        user.setGender("M");
        user.setDescription("Don't have a description");
        user.setIcon("http://freelancer-images.oss-cn-beijing.aliyuncs.com/hello.jpg");
        user.setFriends(null);
        return userRepository.save(user);
    }

    @Override
    public void setUserRole(int userId,int role){
        User user = userRepository.findById(userId).get();
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public List<User> getFriends(int userId) {
        User user = userRepository.findById(userId).get();
        return user.getFriends();
    }

    @Override
    public void deleteFriends(int userId, List<User> li) {
        User user = userRepository.findById(userId).get();
        List<User> l = user.getFriends();
        for (User i : li) l.remove(i);
        user.setFriends(l);
        userRepository.save(user);
    }
}
