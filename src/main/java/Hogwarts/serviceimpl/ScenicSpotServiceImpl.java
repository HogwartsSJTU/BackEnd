package Hogwarts.serviceimpl;

import Hogwarts.entity.ScenicSpot;
import Hogwarts.repository.ScenicSpotRepository;
import Hogwarts.service.ScenicSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenicSpotServiceImpl implements ScenicSpotService {
    @Autowired
    private ScenicSpotRepository scenicSpotRepository;
    @Override
    public ScenicSpot create(String name, double rate, String image, String audio, double lat,
                             double lng, int count, int heat, String profile) {
        ScenicSpot scenicSpot = new ScenicSpot();
        scenicSpot.setName(name);
        scenicSpot.setAudio(audio);
        scenicSpot.setImage(image);
        scenicSpot.setLat(lat);
        scenicSpot.setLng(lng);
        scenicSpot.setCount(count);
        scenicSpot.setHeat(heat);
        scenicSpot.setProfile(profile);
        List<ScenicSpot> li;
        li = scenicSpotRepository.findAll();
        int maxIndex = li.size() - 1;
        int max = 1 + maxIndex;
        scenicSpot.setId(max);
        return scenicSpotRepository.save(scenicSpot);
    }

    @Override
    public List<ScenicSpot> getAll() {
        return scenicSpotRepository.findAll();

    }

    @Override
    public ScenicSpot getById(int id) {
        return scenicSpotRepository.findById(id).get();
    }
}
