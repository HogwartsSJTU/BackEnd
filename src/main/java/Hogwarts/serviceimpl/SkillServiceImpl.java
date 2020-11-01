package Hogwarts.serviceimpl;

import Hogwarts.entity.Skill;
import Hogwarts.repository.SkillRepository;
import Hogwarts.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> getSkills() {
        List<Skill> list;
        list = skillRepository.findAll();
        return list;
    }
}
