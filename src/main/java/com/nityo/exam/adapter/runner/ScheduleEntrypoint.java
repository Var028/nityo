package com.nityo.exam.adapter.runner;

import com.nityo.exam.usecase.scheduler.BankScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Var Arenz G. Villarino
 */

@Component
@RequiredArgsConstructor
public class ScheduleEntrypoint {

    private final BankScheduler bankScheduler;

    @EventListener(ApplicationReadyEvent.class)
    public void triggerSchedulers() {
        bankScheduler.runScheduledTask();
    }

}
