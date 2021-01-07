package Hogwarts.repository;

import Hogwarts.entity.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiaryRepository extends MongoRepository<Diary, Integer> {

}
