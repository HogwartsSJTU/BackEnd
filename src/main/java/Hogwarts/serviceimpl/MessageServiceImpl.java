package Hogwarts.serviceimpl;

import Hogwarts.entity.Message;
import Hogwarts.repository.MessageRepository;
import Hogwarts.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> getMessages(int userId, int friendId) {
        List<Message> li = messageRepository.find(userId, friendId);
        List<Message> li_ = messageRepository.find(friendId, userId);
        li.addAll(li_);
//        Collections.sort(li,
//                new Comparator<Message>() {
//                    public int compare(Message o1, Message o2) {
//                        return o1.getTime().compareTo(o2.getTime());
//                    }
//                });
        return li;
    }

    @Override
    public void createMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void read(int userId, int friendId, String text) { //性能可改进
        List<Message> li = messageRepository.find(friendId, userId);
        for (Message i : li) {
            i.setUnread(true);
            messageRepository.save(i);
        }
    }
    @Override
    public boolean redPoint(int userId, int friendId) { //性能可改进
        List<Message> li = messageRepository.find(friendId, userId);
        for (Message i : li) if (!i.isUnread()) return true;
        return false;
    }
}
