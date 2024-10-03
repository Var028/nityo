package com.nityo.exam.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Var Arenz G. Villarino
 */

@AllArgsConstructor
@Getter
@ToString
public class ScheduleTaskProperty {

    private String scheduleName;

    private String startDate;

    private String endDate;

}
