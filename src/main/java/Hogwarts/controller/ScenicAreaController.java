package Hogwarts.controller;

import Hogwarts.entity.ScenicArea;
import Hogwarts.entity.ScenicSpot;
import Hogwarts.security.PassToken;
import Hogwarts.service.ScenicAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScenicAreaController {
    class Inner {
        public List<String> li;
        public List<String> route;
    }

    @Autowired
    private ScenicAreaService scenicAreaService;

    //新建景区
}
