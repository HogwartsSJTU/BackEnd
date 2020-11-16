package Hogwarts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Scenic")
public class ScenicArea {

    @Id
    private int id;
    private String name;
    private List<ScenicSpot> li;
    private List<ScenicSpot> route;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLi(List<ScenicSpot> li) {
        this.li = li;
    }

    public void setRoute(List<ScenicSpot> route) {
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<ScenicSpot> getLi() {
        return li;
    }

    public List<ScenicSpot> getRoute() {
        return route;
    }
}
