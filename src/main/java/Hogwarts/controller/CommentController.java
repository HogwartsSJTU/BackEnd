package Hogwarts.controller;

import Hogwarts.entity.Comment;
import Hogwarts.security.PassToken;
import Hogwarts.security.UserLoginToken;
import Hogwarts.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService Commentservice;

    //鏂板缓璇勮
    @UserLoginToken
    @PostMapping("/createcomment")
    public Comment create(@RequestParam("uid") int uid,@RequestParam("sid") int sid,@RequestParam("text") String text,
                          @RequestParam("grade") float grade, List<String> images) {
        return Commentservice.create(uid,sid,text,grade,images);
    }

    @PassToken
    @GetMapping("/getComment")
    public List<Comment> getComment(@RequestParam("sid") int sid)
    {
        return Commentservice.getComment(sid);
    }
}
