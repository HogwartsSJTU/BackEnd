package Hogwarts.service;

import Hogwarts.entity.Comment;
import Hogwarts.entity.Note;

import java.util.List;

public interface NoteService {
    Note create(int uid, int sid, String text);
    List<Note> getNote(int sid);
    //void delete(int uid,int sid);
}
