package Hogwarts.serviceimpl;

import Hogwarts.entity.Comment;
import Hogwarts.entity.ScenicArea;
import Hogwarts.entity.ScenicSpot;
import Hogwarts.repository.CommentRepository;
import Hogwarts.repository.ScenicAreaRepository;
import Hogwarts.service.ScenicAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenicAreaServiceImpl implements ScenicAreaService {
    @Autowired
    private ScenicAreaRepository scenicAreaRepository;

    @Override
    public ScenicArea create(String name, List<ScenicSpot> li, List<ScenicSpot> route) {
        ScenicArea scenicArea = new ScenicArea();
        scenicArea.setName(name);
        scenicArea.setLi(li);
        scenicArea.setRoute(route);
        List<ScenicArea> l;
        l = scenicAreaRepository.findAll();
        int maxIndex = li.size()-1;
        int max = 1 + li.get(maxIndex).getId();
        scenicArea.setId(max);
        return scenicAreaRepository.save(scenicArea);
    }
}
