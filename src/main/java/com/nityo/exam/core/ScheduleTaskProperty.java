package com.nityo.exam.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author Var Arenz G. Villarino
 */

@AllArgsConstructor
@Getter
@ToString
public class ScheduleTaskProperty {

    private String scheduleName;

    private String startDate;

    private LocalDateTime endDate;

}
