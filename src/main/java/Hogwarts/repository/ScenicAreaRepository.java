package Hogwarts.repository;

import Hogwarts.entity.ScenicArea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScenicAreaRepository extends MongoRepository<ScenicArea,Integer> {
}
