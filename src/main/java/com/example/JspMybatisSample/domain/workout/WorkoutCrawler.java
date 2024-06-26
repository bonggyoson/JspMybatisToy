package com.example.JspMybatisSample.domain.workout;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutCrawler {

    private Long id;
    private LocalDate date;
    private Category category;
    private String name;
    private String description;

}
