package Hogwarts.service;

import Hogwarts.entity.Diary;

import java.util.Date;

public interface DiaryService {
    public Diary create(int uid, Date stime, Date etime);
}
