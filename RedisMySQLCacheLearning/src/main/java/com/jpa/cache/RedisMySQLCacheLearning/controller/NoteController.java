package com.jpa.cache.RedisMySQLCacheLearning.controller;

import com.jpa.cache.RedisMySQLCacheLearning.entity.Note;
import com.jpa.cache.RedisMySQLCacheLearning.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> save(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.save(note), HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        noteService.deleteById(id);  // ignore return value
        return ResponseEntity.ok().build();  // 200 OK with nobody
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(noteService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Note> update(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.update(note), HttpStatus.OK);
    }
}
