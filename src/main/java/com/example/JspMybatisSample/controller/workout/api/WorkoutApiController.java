package com.example.JspMybatisSample.controller.workout.api;

import com.example.JspMybatisSample.global.common.CommonResponse;
import com.example.JspMybatisSample.service.workout.WorkoutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/workout")
public class WorkoutApiController {

    private final WorkoutService workoutService;

    @PostMapping("")
    public ResponseEntity<CommonResponse<?>> selectWorkouts() {

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res("오늘의 운동 조회 성공", workoutService.selectWorkouts()));
    }

}
