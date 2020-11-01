package Hogwarts.service;


import Hogwarts.entity.Auction;

import java.util.List;

public interface AuctionService {
    Auction applyJob(int userId, String jobId, String description, int price);
    List<Auction> getAuction(String jobId);
    List<List<String>> getEmployeeAuction(int userId);
}
