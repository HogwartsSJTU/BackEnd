package Hogwarts.service;

import Hogwarts.entity.ScenicSpot;

public interface ScenicSpotService {
    public ScenicSpot create(String name, int rate, String image, String audio, float lat,
                             float lng, int count, int heat, String profile);

    //void updatehot(int sid);
}
