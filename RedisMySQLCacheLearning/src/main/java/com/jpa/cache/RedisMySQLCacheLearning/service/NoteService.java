package com.jpa.cache.RedisMySQLCacheLearning.service;

import com.jpa.cache.RedisMySQLCacheLearning.RedisMySqlCacheLearningApplication;
import com.jpa.cache.RedisMySQLCacheLearning.entity.Note;
import com.jpa.cache.RedisMySQLCacheLearning.repo.NoteRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class NoteService {
    @Autowired
    private NoteRepo noteRepo;

//    private final Logger logger = LoggerFactory.getLogger(NoteService.class);

    public List<Note> findAll() {
        log.info("findAll service");
        log.debug("findAll service");
        return noteRepo.findAll();
    }

    @Cacheable(value = "users",key="#id")
    public Note findById(Integer id) {
        if(noteRepo.findById(id).isPresent()) {
            return noteRepo.findById(id).get();
        }
        log.error("No note present");
        return new Note();
    }

    @CachePut(value = "users",key = "#note.id")
    public Note save(Note note) {
        note.setCreated(new Date());
        return noteRepo.save(note);
    }

    @CacheEvict(value = "users",key = "#id")
    public void deleteById(Integer id) {
        noteRepo.deleteById(id);
    }

    public Note update(Note note) {
        Note note1 = noteRepo.findById(note.getId()).get();
        note1.setTitle(note.getTitle());
        note1.setContent(note.getContent());

        return noteRepo.save(note);
    }
}
