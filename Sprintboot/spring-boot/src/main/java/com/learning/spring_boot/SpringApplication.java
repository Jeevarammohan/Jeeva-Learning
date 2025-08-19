package com.learning.spring_boot;

import com.learning.spring_boot.service.RunnableTest;
import com.learning.spring_boot.service.ThreadTest;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootApplication
public class SpringApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
		ThreadTest threadTest = new ThreadTest();
		threadTest.start();
		Thread th = new Thread(new RunnableTest(),"Runnable Test");
		th.start();
		Runnable runn = ()-> System.out.println("Runnable lambda");
		Thread thr = new Thread(runn,"Thread 1");
		thr.start();
		Thread thr2 = new Thread(()->System.out.println("Thread is running"));
		thr2.start();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		executorService.execute(()->System.out.println("Runnable interface"));
		Future<String> future=executorService.submit(()->"Hello from Callable");
		try {
			String result= future.get();
			System.out.println("Result "+result);
		}
		catch (InterruptedException | ExecutionException e){
			System.out.println(e+"");
		}

	}

}
