package com.example.JspMybatisSample;

import com.example.JspMybatisSample.service.workout.WorkoutCrawlerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JspMybatisSampleApplication implements CommandLineRunner {

    private final WorkoutCrawlerService workoutCrawlerService;

    public static void main(String[] args) {
        SpringApplication.run(JspMybatisSampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        workoutCrawlerService.crawlWods();
        System.out.println("Not Yet :");
    }
}
