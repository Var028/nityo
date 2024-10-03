package com.nityo.exam.usecase.task;

import com.nityo.exam.core.ScheduleTaskProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        LocalDateTime endDate = scheduleTaskProperty.getEndDate();
        LocalDateTime currentDateTime = LocalDateTime.now();
        try {
            while(currentDateTime.isBefore(endDate)) { // assuming thousand of files with thousand of contents need to process so we use while loop
                log.info("Performing task for: {}, with zero dependency to other task \n Verifying customer details \n Saving the customers details \n Notifying the customers \n Customer task is Done!", scheduleTaskProperty.getScheduleName().toUpperCase());
                Thread.sleep(5000L);
                currentDateTime = LocalDateTime.now();
            }
            log.info("CustomerTaskProcessorService is terminated with the end date of {}", endDate);
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
