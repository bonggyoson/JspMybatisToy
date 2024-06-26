 package com.example.JspMybatisSample.service.workout;

import com.example.JspMybatisSample.domain.workout.Workout;
import com.example.JspMybatisSample.domain.workout.WorkoutCrawler;
import com.example.JspMybatisSample.mapper.workout.WorkoutMapper;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutMapper workoutMapper;

    public Workout selectWorkouts() {
        List<Workout> workoutCralwers = workoutMapper.selectWorkouts();

        Random random = new Random();
        int randomWorkout = random.nextInt(workoutCralwers.size());

        return workoutCralwers.get(randomWorkout);
    }
}
