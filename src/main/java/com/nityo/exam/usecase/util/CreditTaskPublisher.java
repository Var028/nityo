package com.nityo.exam.usecase.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author Var Arenz G. Villarino
 */

@Component
@RequiredArgsConstructor
public class CreditTaskPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(boolean isCreditingDone) {
        applicationEventPublisher.publishEvent(new CreditTaskSubject(this, isCreditingDone));
    }


}
