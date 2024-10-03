package com.nityo.exam.usecase.factory;

import com.nityo.exam.core.ScheduleTaskProperty;
import com.nityo.exam.usecase.task.TaskProcessorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Var Arenz G. Villarino
 */

@Component
public class TaskFactory {

    private final Map<String, TaskProcessorService> taskMap = new HashMap<>();

    public TaskFactory(@Qualifier("accountTaskProcessorService") TaskProcessorService accountTaskProcessorService,
                       @Qualifier("creditTaskProcessorService") TaskProcessorService creditTaskProcessorService,
                       @Qualifier("customerTaskProcessorService") TaskProcessorService customerTaskProcessorService) {
        this.taskMap.put("account", accountTaskProcessorService);
        this.taskMap.put("credit", creditTaskProcessorService);
        this.taskMap.put("customer", customerTaskProcessorService);
    }

    public void performTask(ScheduleTaskProperty scheduleTaskProperty) {
        taskMap.get(scheduleTaskProperty.getScheduleName()).performTask(scheduleTaskProperty);
    }

}
