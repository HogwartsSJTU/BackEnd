package Hogwarts.controller;

import Hogwarts.entity.Comment;
import Hogwarts.security.PassToken;
import Hogwarts.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    private CommentService Commentservice;

    //新建评论
    @PassToken
    @PostMapping("/createcomment")
    public Comment create(@RequestParam("uid") int uid,@RequestParam("sid") int sid,@RequestParam("text") String text,@RequestParam("grade") int grade) {
        return Commentservice.create(uid,sid,text,grade);
    }
}
