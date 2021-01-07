package Hogwarts.controller;

import Hogwarts.entity.Diary;
import Hogwarts.repository.DiaryRepository;
import Hogwarts.security.PassToken;
import Hogwarts.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class DiaryController {
    @Autowired
    private DiaryService diaryService;
    @Autowired
    private DiaryRepository diaryRepository;

    @PassToken
    @GetMapping("/createDiary")
    //用户id：uid，开始时间：stime，结束时间etime
    public Diary create(@RequestParam("uid") int uid, @RequestParam("stime") Date stime,
                        @RequestParam("etime") Date etime) {
        return diaryService.create(uid,stime,etime);
    }

    @PassToken
    @GetMapping("/displayDiary")
    public List<Diary> display(@RequestParam("uid") int uid) {
        return diaryRepository.findByUid(uid);
    }

    @PassToken
    @PostMapping("/deleteDiary")
    public boolean delete(@RequestParam("id") int id) {
        diaryRepository.deleteById(id);
        return true;
    }
}
