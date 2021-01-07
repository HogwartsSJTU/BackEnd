package Hogwarts.service;

import Hogwarts.entity.ScenicSpot;

public interface ScenicSpotService {
    ScenicSpot create(String name, String location, double lx, double ly, String description, int hot);
    //void updatehot(int sid);
}
