package com.example.springapp.service;

import com.example.springapp.repository.CourseRepo;
import org.springframework.stereotype.Service;
import com.example.springapp.repository.LessonRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


import com.example.springapp.model.Lesson;

@Service
public class LessonServices {

    @Autowired
    private LessonRepo lessonRepo;

    public ResponseEntity<?> getAllLessons(){
        List<Lesson>list = lessonRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    public ResponseEntity<?> getLessonById(int id) {
        Object o = lessonRepo.findById(id);
        if (o != null) {
            return ResponseEntity.status(HttpStatus.OK).body(o);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<?> saveLesson(Lesson lesson) {
        lessonRepo.save(lesson);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<?> updateLesson(Lesson lesson, int id) {
        Object o = lessonRepo.findById(id);
        if (o != null) {
            lessonRepo.save(lesson);
            return ResponseEntity.status(HttpStatus.OK).body(o);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    public ResponseEntity<?> deleteLessonById(int id) {
        Object o = lessonRepo.findById(id);
        Lesson l = (Lesson)o;
        if (l != null) {
            lessonRepo.delete(l);
            return ResponseEntity.status(HttpStatus.OK).body(l);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
