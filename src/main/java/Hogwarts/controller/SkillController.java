package Hogwarts.controller;

import Hogwarts.entity.Skill;
import Hogwarts.security.UserLoginToken;
import Hogwarts.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;


    //获得所有技能
    @UserLoginToken
    @GetMapping("/getSkills")
    public List<Skill> getSkills() {
        return skillService.getSkills();
    }
  }
