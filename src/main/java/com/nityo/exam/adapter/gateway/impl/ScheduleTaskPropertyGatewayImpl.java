package com.nityo.exam.adapter.gateway.impl;

import com.nityo.exam.adapter.gateway.ScheduleTaskPropertyGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Var Arenz G. Villarino
 */

@Component
public class ScheduleTaskPropertyGatewayImpl implements ScheduleTaskPropertyGateway {

    @Value("${schedule.task.names}")
    private String scheduleTaskNames;

    @Override
    public String getScheduleNames() {
        return scheduleTaskNames;
    }
}
