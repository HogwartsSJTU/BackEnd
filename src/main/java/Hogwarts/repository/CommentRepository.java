package Hogwarts.repository;

import Hogwarts.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CommentRepository extends MongoRepository<Comment, Integer> {
    @Query(value="{'$and' : [{'sid' : ?0}, {'uid' : ?1}] }")
    Comment findbysuid(int sid, int uid);
}
