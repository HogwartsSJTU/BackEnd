package Hogwarts.controller;

import Hogwarts.entity.Comment;
import Hogwarts.entity.Note;
import Hogwarts.security.PassToken;
import Hogwarts.security.UserLoginToken;
import Hogwarts.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteService Noteservice;

    //新建到此一游
    @UserLoginToken
    @PostMapping("/createnote")
    public Note create(@RequestParam("uid") int uid,@RequestParam("sid") int sid,@RequestParam("text") String text) {
        return Noteservice.create(uid, sid, text);
    }

    @PassToken
    @GetMapping("/getNote")
    public List<Note> getNote(@RequestParam("sid") int sid)
    {
        return Noteservice.getNote(sid);
    }
}
