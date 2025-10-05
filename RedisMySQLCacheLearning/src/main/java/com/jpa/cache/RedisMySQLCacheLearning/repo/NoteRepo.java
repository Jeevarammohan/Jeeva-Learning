package com.jpa.cache.RedisMySQLCacheLearning.repo;

import com.jpa.cache.RedisMySQLCacheLearning.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends JpaRepository<Note,Integer> {
}
