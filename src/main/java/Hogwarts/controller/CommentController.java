package Hogwarts.controller;

import Hogwarts.entity.Comment;
import Hogwarts.security.PassToken;
import Hogwarts.security.UserLoginToken;
import Hogwarts.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService Commentservice;

    //鏂板缓璇勮
    @UserLoginToken
    @PostMapping("/createcomment")
    public Comment create(@RequestBody Comment comment) {
        return Commentservice.create(comment);
    }

    @PassToken
    @GetMapping("/getComment")
    public List<Comment> getComment(@RequestParam("sid") int sid)
    {
        return Commentservice.getComment(sid);
    }
}
