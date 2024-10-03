package com.nityo.exam.usecase.factory;

import com.nityo.exam.adapter.gateway.ScheduleTaskPropertyGateway;
import com.nityo.exam.core.ScheduleTaskProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Var Arenz G. Villarino
 */

@Component
@RequiredArgsConstructor
public class ScheduleContextFactory {

    private final ScheduleTaskPropertyGateway scheduleTaskPropertyGateway;

    private final Environment environment;

    public List<ScheduleTaskProperty> getScheduleTaskProperties() {

        List<String> prefixNames = Arrays.stream(scheduleTaskPropertyGateway.getScheduleNames()
                .split(","))
                .toList();
        List<ScheduleTaskProperty> scheduleTaskProperties = new ArrayList<>();
        for(String prefixName : prefixNames) {
            ScheduleTaskProperty scheduleTaskProperty = new ScheduleTaskProperty(
                    prefixName,
                    environment.getProperty(prefixName + ".start-date"),
                    environment.getProperty(prefixName + ".end-date")
            );
            scheduleTaskProperties.add(scheduleTaskProperty);
        }
        return scheduleTaskProperties;
    }

}
