package Hogwarts.repository;

import Hogwarts.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, Integer> {

}
