package com.example.JspMybatisSample.domain.workout;

import static lombok.AccessLevel.PROTECTED;

import com.example.JspMybatisSample.global.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Workout extends BaseEntity {

    private Long workoutId;

    private String workoutName;

    private String workoutContent;

}
