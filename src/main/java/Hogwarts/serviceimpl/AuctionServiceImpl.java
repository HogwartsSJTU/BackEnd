package Hogwarts.serviceimpl;

import Hogwarts.entity.Auction;
import Hogwarts.entity.Job;
import Hogwarts.entity.User;
import Hogwarts.repository.AuctionRepository;
import Hogwarts.repository.JobRepository;
import Hogwarts.repository.UserRepository;
import Hogwarts.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    AuctionRepository auctionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JobRepository jobRepository;

    @Override
    public Auction applyJob(int userId, String jobId, String description, int price){
        User user = userRepository.findById(userId).get();
        Job job = jobRepository.findById(jobId).get();
        Auction auction = new Auction();
        auction.setProjectId(jobId);
        auction.setProjectName(job.getTitle());
        auction.setUserId(userId);
        auction.setUserName(user.getName());
        auction.setDescription(description);
        auction.setPrice(price);
        auction.setSkills(user.getSkills());
        auction.setType(job.getType());
        if(job.getCandidateNum() == 0)
        {
            job.setCandidateNum(1);
            job.setLowestPrice(price);
            job.setAvgPrice(price);
        }
        else{
            if(job.getLowestPrice()>price)
                job.setLowestPrice(price);
            job.setAvgPrice((job.getAvgPrice()*job.getCandidateNum()+price)/(job.getCandidateNum()+1));
            job.setCandidateNum(job.getCandidateNum()+1);
        }
        jobRepository.save(job);
        return auctionRepository.save(auction);
    }

    @Override
    public List<Auction> getAuction(String jobId){
        return auctionRepository.getAuction(jobId);
    }

    @Override
    public List<List<String>> getEmployeeAuction(int userId){
        List<Auction> auctions = auctionRepository.findAll();
        List<Auction> filter = new ArrayList<>();
        int size = auctions.size();
        for(int i=0;i<size;i++)
        {
            if(auctions.get(i).getUserId() == userId)
                filter.add(auctions.get(i));
        }
        size = filter.size();
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        Auction auction;
        Job job;
        for(int i=0;i<size;i++)
        {
            auction = filter.get(i);
            job = jobRepository.findById(filter.get(i).getProjectId()).get();
            if(job.getState() == 1 || job.getState() == 2) continue;
            tmp.add(auction.getProjectId());
            tmp.add(auction.getProjectName());
            tmp.add(Integer.toString(job.getState()));
            if(job.getEmployeeId()==0)
                tmp.add("0");
            else {
                if(job.getEmployeeId() == auction.getUserId())
                    tmp.add("1");
                else tmp.add("-1");
            }
            tmp.add(Integer.toString(auction.getPrice()));
            tmp.add(Integer.toString(job.getAvgPrice()));
            tmp.add(job.getDeadline());
            res.add(tmp);
            tmp = new ArrayList<>();
        }
        return res;
    }
}
