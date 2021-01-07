package Hogwarts.repository;

import Hogwarts.entity.Daka;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface DakaRepository extends MongoRepository<Daka, Integer> {
    @Query(value="{'$and': [{'uid' : ?0}, {'time' : {$gte : ?1, $lte : ?2}}]}")
    List<Daka> findbydate(int uid, Date stime, Date etime);
}
