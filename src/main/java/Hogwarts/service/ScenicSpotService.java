package Hogwarts.service;

import Hogwarts.entity.ScenicSpot;

public interface ScenicSpotService {
    public ScenicSpot create(String name, double rate, String image, String audio, double lat,
                             double lng, int count, int heat, String profile);

    //void updatehot(int sid);
}
