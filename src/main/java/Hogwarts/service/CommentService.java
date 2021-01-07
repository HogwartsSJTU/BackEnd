package Hogwarts.service;

import Hogwarts.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment create(int uid, int sid, String text, float grade, List<String> images);
    List<Comment> getComment(int sid);
    //void delete(int uid,int sid);
}
