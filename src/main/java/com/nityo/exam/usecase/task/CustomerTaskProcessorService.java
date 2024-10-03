package com.nityo.exam.usecase.task;

import com.nityo.exam.core.ScheduleTaskProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Var Arenz G. Villarino
 */

@Service("customerTaskProcessorService")
@Slf4j
public class CustomerTaskProcessorService implements TaskProcessorService {

    /**
     *  A task with zero dependedency with the other task
     */
    @Override
    public void performTask(ScheduleTaskProperty scheduleTaskProperty) {
        try {
            log.info("Performing task for: {}, with zero dependency to other task \n Verifying customer details \n Saving the customers details \n Notifying the customers \n Customer task is Done!", scheduleTaskProperty.getScheduleName().toUpperCase());
            Thread.sleep(5000L);
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
