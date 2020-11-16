package Hogwarts.entity;

import java.util.Date;

public class Message {
    private User sender;
    private User receiver;
    private Date time;
    private String text;
    private boolean isLiked;
    private boolean unread;

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
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

    public boolean isLiked() {
        return isLiked;
    }

    public boolean isUnread() {
        return unread;
    }

    public User getSender() {
        return sender;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }
}
