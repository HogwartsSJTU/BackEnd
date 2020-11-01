package Hogwarts.repository;

import Hogwarts.entity.Auction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface AuctionRepository extends MongoRepository<Auction, String> {
    @Query("{ projectId: ?0}")
    public List<Auction> getAuction(String jobId);
}
