package com.jpa.cache.RedisMySQLCacheLearning.controller;

import com.jpa.cache.RedisMySQLCacheLearning.entity.Movie;
import com.jpa.cache.RedisMySQLCacheLearning.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController

public class MovieController {


    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/movies",produces =  MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity> getAllMovies(){
        return movieService.findAll().thenApply(ResponseEntity::ok);
    }

    @PostMapping(value = "/movies",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveMovies(@RequestParam("files") MultipartFile[] files) throws Exception {
        for(MultipartFile file : files){
            movieService.save(file);
        }
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/movies/all")
    public ResponseEntity findAll(){
        CompletableFuture<List<Movie>> movies1=movieService.findAll();
        CompletableFuture<List<Movie>> movies2=movieService.findAll();
        CompletableFuture<List<Movie>> movies3=movieService.findAll();
        CompletableFuture.allOf(movies1,movies2,movies3).join();
        return ResponseEntity.status(HttpStatus.OK).build();


    }
}
