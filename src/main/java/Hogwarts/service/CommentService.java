package Hogwarts.service;

import Hogwarts.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment create(Comment comment);
    List<Comment> getComment(int sid);
    //void delete(int uid,int sid);
}
