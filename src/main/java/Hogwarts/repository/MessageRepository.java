package Hogwarts.repository;

import Hogwarts.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, Integer> {
    @Query(value="{'$and': [{'senderId' : ?0}, {'receiverId' : ?1}]}")
    List<Message> find(int senderId, int receiverId);

}
