package Hogwarts.service;

import Hogwarts.entity.Comment;

public interface CommentService {
    Comment create(int uid, int sid, String text, int grade);
    //void delete(int uid,int sid);
}
