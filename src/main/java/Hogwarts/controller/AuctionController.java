package Hogwarts.controller;

import Hogwarts.entity.Auction;
import Hogwarts.security.UserLoginToken;
import Hogwarts.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuctionController {

    @Autowired
    AuctionService auctionService;
    //申请工作

    @UserLoginToken
    @PostMapping("/applyJob")
    public Auction assignJob(@RequestParam("userId") int userId,@RequestParam("jobId") String jobId,
                             @RequestParam("description") String description, @RequestParam("price") int price)
    {
        return auctionService.applyJob(userId,jobId,description,price);
    }

    @UserLoginToken
    @PostMapping("/getAuction")
    public List<Auction> getAuction(@RequestParam("jobId") String jobId){return auctionService.getAuction(jobId);}

    @UserLoginToken
    @GetMapping("/getEmployeeAuction")
    public List<List<String>> getEmployeeAuction(@RequestParam("userId") int userId){return auctionService.getEmployeeAuction(userId);}
}
