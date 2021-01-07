package Hogwarts.repository;

import Hogwarts.entity.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DiaryRepository extends MongoRepository<Diary, Integer> {
    @Query(value="{'uid' : ?0}")
    List<Diary> findByUid(int uid);
}
