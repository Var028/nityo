package com.nityo.exam.usecase.scheduler;

import com.nityo.exam.core.ScheduleTaskProperty;
import com.nityo.exam.usecase.factory.ScheduleContextFactory;
import com.nityo.exam.usecase.factory.TaskFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Var Arenz G. Villarino
 */

@Service
@RequiredArgsConstructor
public class BankScheduler {

    private final ScheduleContextFactory scheduleContextFactory;

    private final TaskScheduler taskScheduler;

    private final TaskFactory taskFactory;

    private final ExecutorService executor = Executors.newScheduledThreadPool(5);


    public void configureTasks() {

        for(ScheduleTaskProperty scheduleTaskProperty : scheduleContextFactory.getScheduleTaskProperties()) {
            executor.submit(() ->
                    taskScheduler.schedule(() ->
                    taskFactory.performTask(scheduleTaskProperty), new CronTrigger(scheduleTaskProperty.getStartDate()))
            );
        }


    }
}
