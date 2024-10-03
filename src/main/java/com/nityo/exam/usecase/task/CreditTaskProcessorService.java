package com.nityo.exam.usecase.task;

import com.nityo.exam.core.ScheduleTaskProperty;
import com.nityo.exam.usecase.util.CreditTaskPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
            log.info("Running some ETL(Spring Batch) for calculation \n and persisting of data in Database... \n this task may delay the execution of Account Task");
            Thread.sleep(5000L); // let's assume that this task takes 5 seconds
        }catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            creditTaskPublisher.publish(true);
            log.info("Done Crediting of cash and persisting of data in the Database");
        }
    }

}
