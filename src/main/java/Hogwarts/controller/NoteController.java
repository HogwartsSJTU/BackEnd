package Hogwarts.controller;

import Hogwarts.entity.Note;
import Hogwarts.security.PassToken;
import Hogwarts.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {
    @Autowired
    private NoteService Noteservice;

    //新建到此一游
    @PassToken
    @PostMapping("/createnote")
    public Note create(@RequestParam("uid") int uid,@RequestParam("sid") int sid,@RequestParam("text") String text) {
        return Noteservice.create(uid, sid, text);
    }

}
