package com.nityo.exam.usecase.task;

import com.nityo.exam.core.ScheduleTaskProperty;
import com.nityo.exam.usecase.util.CreditTaskSubject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Var Arenz G. Villarino
 */

@Service("accountTaskProcessorService")
@Slf4j
public class AccountTaskProcessorService implements TaskProcessorService, ApplicationListener<CreditTaskSubject> {

    private boolean isCreditingDone = false;

    /**
     *  A task that dependent on {@link CreditTaskProcessorService}
     */
    @Override
    public void performTask(ScheduleTaskProperty scheduleTaskProperty) {
        log.info("Account task started... \n verifying if crediting is Done!");
            try {
                delayExecution();
                log.info("Crediting is done. Performing Account Reconciliation Task");
                Thread.sleep(2000L); // let's assume this process takes 2secs

            } catch (Exception e) {
                log.error("Error: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
    }

    /**
     *  Subscribe or listen to {@link CreditTaskSubject} changes
     */
    @Override
    public void onApplicationEvent(CreditTaskSubject event) {
        this.isCreditingDone = event.getIsCreditingDone();
    }

    /**
     *  Check the object if modified from time to time
     */
    private void delayExecution() throws InterruptedException {
        log.info("isCreditingDone: {}", isCreditingDone);
        if(!isCreditingDone) {
            log.info("Crediting is currently on process. Waiting for the task to be compleated");
            TimeUnit.SECONDS.sleep(2L);
            log.info("Delaying...");
            delayExecution();
        }
    }

}
