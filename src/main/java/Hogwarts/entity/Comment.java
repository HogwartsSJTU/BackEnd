package Hogwarts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comment")
public class Comment {

    @Id
    private int id;
    private String text;
    private String time;
    private String image;
    private int grade;
    private int sid;
    private int uid;

    public String getTime() {
        return time;
    }

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

    public void setTime(String time) {
        this.time = time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
}
