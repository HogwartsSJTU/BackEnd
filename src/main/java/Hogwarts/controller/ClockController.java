package Hogwarts.controller;

import Hogwarts.entity.Clock;
import Hogwarts.repository.ClockRepository;
import Hogwarts.security.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ClockController {
    @Autowired
    private ClockRepository clockRepository;

    @PassToken
    @PostMapping("/clock")
    public boolean clock(@RequestParam("uid") int uid, @RequestParam("sid") int sid, @RequestParam("date") Date date) {
        Clock clock = new Clock();
        clock.setSid(sid);
        clock.setUid(uid);
        clock.setTime(date);
        List<Clock> li=clockRepository.findAll();
        if (li.size() == 0) clock.setId(0);
        else clock.setId(1+li.get(li.size()-1).getId());
        clockRepository.save(clock);
        return true;
    }
}
