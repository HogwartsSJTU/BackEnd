package Hogwarts.repository;

import Hogwarts.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note,Integer> {
    @Query(value = "{'$and': [{ 'uid':?0}]}")
    List<Note> find(int uid);
}
