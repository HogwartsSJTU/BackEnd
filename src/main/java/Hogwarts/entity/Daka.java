package Hogwarts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Daka")
public class Daka {
    @Id
    int id;
    int sid; //景点id
    int uid; //用户id
    Date time; //打卡时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getUid() {
        return uid;
    }

    public int getSid() {
        return sid;
    }

    public Date getTime() {
        return time;
    }
}
