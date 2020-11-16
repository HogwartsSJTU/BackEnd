package Hogwarts.controller;

import Hogwarts.entity.Message;
import Hogwarts.security.PassToken;
import Hogwarts.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PassToken
    @GetMapping("/getMessage")
    public List<Message> getMessage(@RequestParam("userId") int userId, @RequestParam("friendId") int friendId) {
        return messageService.getMessages(userId, friendId);
    }

}
