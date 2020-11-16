package Hogwarts.repository;

import Hogwarts.entity.ScenicSpot;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScenicSpotRepository extends MongoRepository<ScenicSpot,Integer> {
}
