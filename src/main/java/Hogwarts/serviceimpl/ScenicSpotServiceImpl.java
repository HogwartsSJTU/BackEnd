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
    public ScenicSpot create(String name, String location, float lx, float ly, String description, int hot) {
        ScenicSpot scenicSpot = new ScenicSpot();
        scenicSpot.setDescription(description);
        scenicSpot.setHot(hot);
        scenicSpot.setLocation(location);
        scenicSpot.setLx(lx);
        scenicSpot.setLy(ly);
        scenicSpot.setName(name);
        List<ScenicSpot> li;
        li = scenicSpotRepository.findAll();
        int maxIndex = li.size() - 1;
        int max = 1 + li.get(maxIndex).getId();
        scenicSpot.setId(max);
        return scenicSpotRepository.save(scenicSpot);
    }

}
