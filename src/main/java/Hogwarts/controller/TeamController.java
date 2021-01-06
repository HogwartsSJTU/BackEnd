package Hogwarts.controller;

import Hogwarts.entity.Team;
import Hogwarts.entity.TeamInvite;
import Hogwarts.entity.User;
import Hogwarts.entity.pos;
import Hogwarts.repository.UserRepository;
import Hogwarts.security.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class TeamController {
    @Autowired
    private UserRepository userRepository;

    private int TeamNum = 0;
    private Team[] team = new Team[100];

    @PassToken
    @PostMapping("createTeam")
    public Team create(@RequestParam("uid") int uid)
    {
        Team t = new Team();
        t.id = TeamNum+1;
        t.num = 1;
        t.people[0] = uid;
        t.state = 1;
        team[TeamNum] = t;
        TeamNum++;
        User u = userRepository.findById(uid).get();
        u.teamId = t.id;
        userRepository.save(u);
        return t;
    }

    @PassToken
    @PostMapping("inviteTeam")
    public void addTeam(@RequestParam("tid") int tid,@RequestParam("uid1") int uid1,@RequestParam("uid2") int uid2)
    {
        TeamInvite tmp = new TeamInvite();
        tmp.tid = tid;
        tmp.uid = uid1;
        User user  = userRepository.findById(uid2).get();
        if(user.teamInvites == null)
            user.teamInvites = new ArrayList<>();
        user.teamInvites.add(tmp);
        userRepository.save(user);
    }

    @PassToken
    @PostMapping("addTeam")
    public Team addTeam(@RequestParam("uid") int uid,@RequestParam("tid") int tid)
    {
        Team t = team[(tid-1)];
        t.people[t.num] = uid;
        t.num++;
        team[(t.id-1)] = t;
        User u = userRepository.findById(uid).get();
        u.teamId = tid;
        userRepository.save(u);
        return t;
    }

    @PassToken
    @GetMapping("getTeam")
    public Team getTeam(@RequestParam("tid") int tid)
    {
        return team[(tid-1)];
    }

    @PassToken
    @GetMapping("deleteTeam")
    public void deleteTeam(@RequestParam("tid") int tid)
    {
        Team t = team[tid-1];
        t.state = 0;
        team[tid-1] = t;
        for(int i=0;i<t.num;i++)
        {
            User u = userRepository.findById(t.people[i]).get();
            u.teamId = 0;
            userRepository.save(u);
        }
    }

    @PassToken
    @PostMapping("updatePosition")
    public Team updatePosition(@RequestParam("tid") int tid,@RequestParam("uid") int uid,@RequestParam("x") double x,@RequestParam("y") double y)
    {
        Team t = team[tid-1];
        int i = 0;
        for(;i<t.num;i++)
        {
            if(t.people[i] == uid)
                break;;
        }
        pos tmp = new pos();
        tmp.x = x;
        tmp.y = y;
        t.position[i] = tmp;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        t.time[i] = df.format(new Date());
        team[tid-1] = t;
        return t;
    }
}
