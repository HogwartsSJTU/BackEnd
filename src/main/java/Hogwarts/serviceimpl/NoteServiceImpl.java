package Hogwarts.serviceimpl;

import Hogwarts.entity.Comment;
import Hogwarts.entity.Note;
import Hogwarts.repository.NoteRepository;
import Hogwarts.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note create(int uid, int sid, String text) {
        Note note = new Note();
        note.setSid(sid);
        note.setText(text);
        note.setUid(uid);
        List<Note> li;
        li = noteRepository.findAll();
        int maxIndex = li.size()-1;
        int max = 1 + li.get(maxIndex).getId();
        note.setId(max);
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getNote(int sid){
        return noteRepository.findbysid(sid);
    }
}
