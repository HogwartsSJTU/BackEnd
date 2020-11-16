package Hogwarts.service;

import Hogwarts.entity.Note;

public interface NoteService {
    Note create(int uid, int sid, String text);
    //void delete(int uid,int sid);
}
