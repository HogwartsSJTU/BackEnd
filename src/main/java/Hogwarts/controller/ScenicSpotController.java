package Hogwarts.controller;

import Hogwarts.entity.ScenicSpot;
import Hogwarts.security.PassToken;
import Hogwarts.service.ScenicSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScenicSpotController {
    @Autowired
    private ScenicSpotService scenicSpotService;

    @PassToken
    @PostMapping("")
    public ScenicSpot create(@RequestParam("name") String name, @RequestParam("location") String location,
                             @RequestParam("lx") double lx, @RequestParam("ly") double ly,
                             @RequestParam("description") String description, @RequestParam("hot") int hot) {
        return scenicSpotService.create(name,location,lx,ly,description,hot);
    }
}
