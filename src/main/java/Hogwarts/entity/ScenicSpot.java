package Hogwarts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ScenicSpot")
public class ScenicSpot {

    @Id
    private int id;
    private String name;
    private double rate;
    private String image;
    private String audio;
    private double lat;
    private double lng;
    private int count;
    private int heat;
    private String profile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public int getCount() {
        return count;
    }

    public int getHeat() {
        return heat;
    }

    public double getRate() {
        return rate;
    }

    public String getAudio() {
        return audio;
    }

    public String getImage() {
        return image;
    }

    public String getProfile() {
        return profile;
    }

    public void setAudio(String audio) {
        this.audio = audio;

    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
