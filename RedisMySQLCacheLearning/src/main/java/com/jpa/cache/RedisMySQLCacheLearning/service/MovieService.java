package com.jpa.cache.RedisMySQLCacheLearning.service;

import com.jpa.cache.RedisMySQLCacheLearning.entity.Movie;
import com.jpa.cache.RedisMySQLCacheLearning.repo.MovieRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    private final Logger log = LoggerFactory.getLogger(MovieService.class);


    @Async
    public CompletableFuture<List<Movie>> save(MultipartFile file) throws Exception {
        long start=System.currentTimeMillis();
        List<Movie> movies=parseCSVFile(file);
        movieRepo.saveAll(movies);
        log.info("Saving list of movie details of size :{} {}", movies.size(),Thread.currentThread().getName());

        long end =  System.currentTimeMillis();
        log.info("Total time taken {}",end-start);
        return CompletableFuture.completedFuture(movies);

    }

    @Async
    public CompletableFuture<List<Movie>> findAll()  {
        log.info("Finding all movies {}", Thread.currentThread().getName());
        return CompletableFuture.completedFuture(movieRepo.findAll());

    }
    private List<Movie> parseCSVFile(final MultipartFile file) throws Exception{
        List<Movie> movies = new ArrayList<>();
        try{
            try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    final String[] split = line.split(",");
                    final Movie movie = new Movie();
                    movie.setTitle(split[0]);
                    movie.setGenre(split[1]);
                    movie.setDirector(split[2]);
                    movies.add(movie);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        return movies;
    }
}
