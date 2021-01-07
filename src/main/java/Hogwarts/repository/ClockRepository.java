package Hogwarts.repository;

import Hogwarts.entity.Clock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface ClockRepository extends MongoRepository<Clock, Integer> {
    @Query(value="{'$and': [{'uid' : ?0}, {'time' : {$gte : ?1, $lte : ?2}}]}")
    List<Clock> findbydate(int uid, Date stime, Date etime);
}
