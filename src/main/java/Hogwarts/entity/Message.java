package Hogwarts.entity;

import java.util.Date;

public class Message {
    private int senderid;
    private int receiverid;
    private Date time;
    private String text;
    private boolean unread; //false:unread; true:read

    public int getReceiverid() {
        return receiverid;
    }

    public int getSenderid() {
        return senderid;
    }

    public void setReceiverid(int receiverid) {
        this.receiverid = receiverid;
    }

    public void setSenderid(int senderid) {
        this.senderid = senderid;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public Date getTime() {
        return time;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }
}
