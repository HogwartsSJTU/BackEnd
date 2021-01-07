package Hogwarts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ScenicSpot")
public class ScenicSpot {

    @Id
    private int id;
    private String name;
    private String location;
    private double lx;
    private double ly;
    private String description;
    private int hot;

    public double getLx() {
        return lx;
    }

    public double getLy() {
        return ly;
    }

    public int getHot() {
        return hot;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLx(double lx) {
        this.lx = lx;
    }

    public void setLy(double ly) {
        this.ly = ly;
    }

    public void setName(String name) {
        this.name = name;
    }

}
