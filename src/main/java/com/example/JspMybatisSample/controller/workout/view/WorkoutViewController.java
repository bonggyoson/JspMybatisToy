package com.example.JspMybatisSample.controller.workout.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/workout")
public class WorkoutViewController {

    @GetMapping()
    public String getWorkout(Model model) {
        model.addAttribute("today", LocalDate.now());
        
        return "workout/workout_random";
    }

}
