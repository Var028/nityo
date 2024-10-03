package com.nityo.exam.usecase.util;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author Var Arenz G. Villarino
 */

@Getter
public class CreditTaskSubject extends ApplicationEvent {

    private final Boolean isCreditingDone;

    public CreditTaskSubject(Object source, Boolean isCreditingDone) {
        super(source);
        this.isCreditingDone = isCreditingDone;
    }
}
