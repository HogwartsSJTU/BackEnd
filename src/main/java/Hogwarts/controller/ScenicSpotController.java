package Hogwarts.controller;

import Hogwarts.entity.ScenicSpot;
import Hogwarts.repository.ScenicSpotRepository;
import Hogwarts.security.PassToken;
import Hogwarts.service.ScenicSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScenicSpotController {
    @Autowired
    private ScenicSpotService scenicSpotService;
    @Autowired
    private ScenicSpotRepository scenicSpotRepository;

    @PassToken
    @PostMapping("/createScenicSpot")
    public ScenicSpot create(@RequestParam("name") String name, @RequestParam("rate") int rate,
                             @RequestParam("image") String image, @RequestParam("audio") String audio,
                             @RequestParam("lat") double lat, @RequestParam("lng") double lng,
                             @RequestParam("count") int count, @RequestParam("heat") int heat,
                             @RequestParam("profile") String profile) {
        return scenicSpotService.create(name,rate,image,audio,lat,lng,count,heat,profile);
    }

    @PassToken
    @PostMapping("/modifyScenicSpot")
    public boolean modify(@RequestBody ScenicSpot scenicSpot) {
        scenicSpotRepository.save(scenicSpot);
        return true;
    }

    @PassToken
    @GetMapping("/getAll")
    public List<ScenicSpot> getAll() {
        return scenicSpotService.getAll();
    }

    @PassToken
    @GetMapping("/getScenicSpot")
    public ScenicSpot getScenicSpot(int id) {
        return scenicSpotService.getById(id);
    }
}
