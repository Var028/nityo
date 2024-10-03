package com.nityo.exam.usecase.task;

import com.nityo.exam.core.ScheduleTaskProperty;
import com.nityo.exam.usecase.util.CreditTaskPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Var Arenz G. Villarino
 */

@Service("creditTaskProcessorService")
@RequiredArgsConstructor
@Slf4j
public class CreditTaskProcessorService implements TaskProcessorService {

    private final CreditTaskPublisher creditTaskPublisher;

    /**
     *  The {@link AccountTaskProcessorService} is depending on this
     *  task
     */
    @Override
    public void performTask(ScheduleTaskProperty scheduleTaskProperty) {
        creditTaskPublisher.publish(false);
        try {
            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime endDate = scheduleTaskProperty.getEndDate();
            while(currentDateTime.isBefore(endDate)) { // assuming thousand of files with thousand of contents need to process so we use while loop
                log.info("Running some ETL(Spring Batch) for calculation \n and persisting of data in Database... \n this task may delay the execution of Account Task");
                Thread.sleep(5000L); // let's assume that this task takes 5 seconds
                currentDateTime = LocalDateTime.now();
            }
            log.info("CreditTaskProcessorService is terminated with the end date of {}", endDate);

        }catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            creditTaskPublisher.publish(true);
            log.info("Done Crediting of cash and persisting of data in the Database");
        }
    }

}
