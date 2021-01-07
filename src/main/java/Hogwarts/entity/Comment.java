package Hogwarts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Comment")
public class Comment {

    @Id
    private String id;
    private String text;
    private float grade;
    private int sid;
    private int uid;
    private List<String> images;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {this.images = images; }

    public String getText() {
        return text;
    }

    public int getUid() {
        return uid;
    }

    public int getSid() {
        return sid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

}
