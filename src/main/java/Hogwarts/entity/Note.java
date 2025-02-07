package Hogwarts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Note")
public class Note {

    @Id
    private int id;
    private String text;
    private int sid;
    private int uid;

    public int getId() {
        return id;
    }

    public int getSid() {
        return sid;
    }

    public int getUid() {
        return uid;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
