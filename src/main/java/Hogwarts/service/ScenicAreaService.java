package Hogwarts.service;

import Hogwarts.entity.ScenicArea;
import Hogwarts.entity.ScenicSpot;

import java.util.List;

public interface ScenicAreaService {
    ScenicArea create(String name, List<ScenicSpot> li, List<ScenicSpot> route);
}

