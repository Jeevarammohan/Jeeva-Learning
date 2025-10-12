package com.learning.SpringBatch.controller;


import com.learning.SpringBatch.model.Customer;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobLauncherController {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    @GetMapping("/start-job")
    public String startJob(){
        try{
            JobParameters jobParameter = new JobParametersBuilder()
                    .addLong("startTime",System.currentTimeMillis()).toJobParameters();

            JobExecution jobExecution =jobLauncher.run(job,jobParameter);
            return jobExecution.getStatus().toString();

        }
        catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
