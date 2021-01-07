package Hogwarts.controller;

import Hogwarts.entity.Message;
import Hogwarts.security.PassToken;
import Hogwarts.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PassToken
    @PostMapping("/createMessage")
    public boolean createMessage(@RequestBody Message message) {
        messageService.createMessage(message);
        return true;
    }

    @PassToken
    @PostMapping("/read")
    public boolean read(@RequestParam("userId") int userId, @RequestParam("freindId") int friendId,
                        @RequestParam("text") String text) {
        messageService.read(userId,friendId,text);
        return true;
    }

    @PassToken
    @GetMapping("/redPoint")
    // true 表示有未读消息，false 表示无未读消息
    public boolean redPoint(@RequestParam("userId") int userId, @RequestParam("friendId") int friendId) {
        return messageService.redPoint(userId,friendId);
    }
}
