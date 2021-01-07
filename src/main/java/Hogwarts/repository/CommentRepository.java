package Hogwarts.repository;

import Hogwarts.entity.Comment;
import Hogwarts.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, Integer> {

    @Query(value="{'$and': [{ 'sid':?0}]}")
    List<Comment> findbysid(int sid);

    @Query(value="{'$and' : [{'sid' : ?0,}, {'uid' : ?1}]}")
    Comment findbysuid(int uid, int sid);
}
