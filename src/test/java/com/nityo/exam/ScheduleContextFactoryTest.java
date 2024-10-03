package com.nityo.exam;

import com.nityo.exam.usecase.factory.ScheduleContextFactory;
import com.nityo.exam.core.ScheduleTaskProperty;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Var Arenz G. Villarino
 */

@SpringBootTest
@Slf4j
class ScheduleContextFactoryTest {

    @Autowired
    private ScheduleContextFactory scheduleContextFactory;

    @Test
    void testPropertiesExisting() {
        List<ScheduleTaskProperty> scheduleTaskProperties = scheduleContextFactory.getScheduleTaskProperties();
        assertNotNull(scheduleTaskProperties);
        assertFalse(scheduleTaskProperties.isEmpty());
        log.info("List: {}", scheduleTaskProperties);
    }

}
