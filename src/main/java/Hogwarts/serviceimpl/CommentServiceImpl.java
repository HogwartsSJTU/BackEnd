package Hogwarts.serviceimpl;

import Hogwarts.entity.Comment;
import Hogwarts.repository.CommentRepository;
import Hogwarts.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment create(int uid,int sid,String text,float grade,List<String> images) {
        Comment comment = new Comment();
        comment.setGrade(grade);
        comment.setSid(sid);
        comment.setText(text);
        comment.setUid(uid);
        comment.setImages(images);
        List<Comment> li;
        li = commentRepository.findAll();
        int maxIndex = li.size()-1;
        int max = 1 + li.get(maxIndex).getId();
        comment.setId(max);
        return commentRepository.save(comment);
    }
    @Override
    public List<Comment> getComment(int sid){
        return commentRepository.findbysid(sid);
    }

}
