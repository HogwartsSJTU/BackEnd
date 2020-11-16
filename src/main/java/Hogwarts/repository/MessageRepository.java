package Hogwarts.repository;

import Hogwarts.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message,Integer> {
    @Query(value="{'$and': [{ 'sender':?0},{'receiver':?1}]}")
    List<Message> find(int sender, int receiver);

}
