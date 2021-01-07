package Hogwarts.repository;

import Hogwarts.entity.Comment;
import Hogwarts.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note,Integer> {

    @Query(value="{'$and': [{ 'sid':?0}]}")
    List<Note> findbysid(int sid);
}
