package Hogwarts.service;

import Hogwarts.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> getMessages(int userId, int friendId);

}
