package Hogwarts.service;

import Hogwarts.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> getMessages(int userId, int friendId);

    void createMessage(Message message);

    void read(int userId, int friendId);

    boolean redPoint(int userId, int friendId);
}
