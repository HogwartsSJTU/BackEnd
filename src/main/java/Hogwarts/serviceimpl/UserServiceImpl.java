package Hogwarts.serviceimpl;

import Hogwarts.entity.TeamInvite;
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
    public void updateUserInfo(User user){
        userRepository.save(user);
    };

    @Override
    public User findUserByphone(String phone){
        return userRepository.findUserByphone(phone);
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
        token= JWT.create().withAudience(user.getPhone())
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
//            user.setPassword("已隐藏");
            return user;
        }
        else return null;
    }

    @Override
    public User login(String phone, String password){
        User user = userRepository.login(phone,password);
        return user;
    }

    @Override
    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public User signup(String name, String password, String address, String phone){
        User user = new User();
        List<User> list;
        list = userRepository.findAll();
        int maxIndex = list.size()-1;
        int max = 1 + list.get(maxIndex).getId();
        user.setId(max);
        user.setRole(0);
        user.setName(name);
        user.setPassword(password);
        user.setEmail(null);
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
        List<Integer> list = user.getFriends();
        List<User> tmp = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            User t  = userRepository.findById(list.get(i)).get();
            t.setPassword("已隐藏");
            tmp.add(t);
        }
        return tmp;
    }

    @Override
    public void deleteFriends(int userId,int friendId) {
        User user = userRepository.findById(userId).get();
        List<Integer> l = user.getFriends();
        if(!l.contains(friendId))
            return;
        int i = 0;
        for(;i<l.size();i++)
            if(l.get(i) == friendId)
                {
                    l.remove(i);
                    break;
                }
        user.setFriends(l);
        userRepository.save(user);
    }

    @Override
    public void applyFriend(int userId,int friendId){
        User user = userRepository.findById(friendId).get();
        List<Integer> list = user.getApply();
        if(list.contains(userId))
            return;
        list.add(userId);
        user.setApply(list);
        userRepository.save(user);
    }

    @Override
    public void addFriend(int userId,int friendId){
        User user = userRepository.findById(userId).get();
        List<Integer> list = user.getApply();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i) == friendId)
            {
                list.remove(i);
                break;
            }
        }
        user.setApply(list);
        list = user.getFriends();
        if(!list.contains(friendId))
            list.add(friendId);
        user.setFriends(list);
        userRepository.save(user);
    }
    @Override
    public void rejectFriend(int userId,int friendId){
        User user = userRepository.findById(userId).get();
        List<Integer> list = user.getApply();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i) == friendId)
            {
                list.remove(i);
                break;
            }
        }
        user.setApply(list);
        userRepository.save(user);
    }

    @Override
    public void rejectTeam(int userId,int tid){
        User user = userRepository.findById(userId).get();
        List<TeamInvite> list = user.teamInvites;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).tid == tid)
            {
                list.remove(i);
                break;
            }
        }
        user.teamInvites = list;
        userRepository.save(user);
    }
}
