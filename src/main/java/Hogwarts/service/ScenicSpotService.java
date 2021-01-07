package Hogwarts.service;

import Hogwarts.entity.ScenicSpot;

import java.util.List;

public interface ScenicSpotService {
    ScenicSpot create(String name, double rate, String image, String audio, double lat,
                             double lng, int count, int heat, String profile);
    List<ScenicSpot> getAll();

    ScenicSpot getById(int id);
    //void updatehot(int sid);
}
