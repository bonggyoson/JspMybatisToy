package com.example.JspMybatisSample.mapper.workout;

import com.example.JspMybatisSample.domain.workout.Workout;
import com.example.JspMybatisSample.domain.workout.WorkoutCrawler;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkoutMapper {

    int insertWorkout(List<WorkoutCrawler> workoutCrawler);

    List<Workout> selectWorkouts();

}
