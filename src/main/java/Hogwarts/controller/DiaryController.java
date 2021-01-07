package Hogwarts.controller;

import Hogwarts.entity.Daka;
import Hogwarts.entity.Diary;
import Hogwarts.entity.Note;
import Hogwarts.repository.CommentRepository;
import Hogwarts.repository.DakaRepository;
import Hogwarts.repository.DiaryRepository;
import Hogwarts.repository.NoteRepository;
import Hogwarts.security.PassToken;
import Hogwarts.service.CommentService;
import Hogwarts.service.DiaryService;
import Hogwarts.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @PassToken
    @GetMapping("/creatediary")
    //用户id：uid，开始时间：stime，结束时间etime
    public Diary create(@RequestParam("uid") int uid, @RequestParam("stime") Date stime,
                        @RequestParam("etime") Date etime) {
        return diaryService.create(uid,stime,etime);
    }

}
