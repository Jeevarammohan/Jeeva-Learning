package com.jpa.mapping.JPALearning.service;

import com.jpa.mapping.JPALearning.model.Student;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class APIService {

    @CacheEvict(value = "twenty-second-cache",key="'StudentCache'+#studentId",beforeInvocation = true,condition = "#isCacheable ==null || !#isCacheable" )
    @Cacheable(value = "ten-second-cache",key="'StudentCache'+#studentId",condition = "#isCacheable !=null && #isCacheable")
    public Optional<Student> fetchStudent(String studentId,boolean isCacheable) throws InterruptedException{
        Thread.sleep(2000);

        return  Stream.of(
                new Student("1","Jaya","Bachchan",50,"Mumbai")
                , new Student("2","Abhishek","Bachchan",40,"Mumbai")
                , new Student("3","Amitabh","Bachchan",55,"Mumbai")
                , new Student("4","Aishwarya","Bachchan",40,"Mumbai")


        ).filter(x->x.getId().equalsIgnoreCase(studentId)).findFirst();
    }
}
