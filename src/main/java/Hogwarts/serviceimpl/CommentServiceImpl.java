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
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }
    @Override
    public List<Comment> getComment(int sid){
        return commentRepository.findbysid(sid);
    }

}
