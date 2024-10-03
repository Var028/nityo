package com.nityo.exam.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @author Var Arenz G. Villarino
 */

@Configuration
@EnableScheduling
@PropertySource("classpath:task-scheduler.properties")
public class SchedulePropertyConfig {

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(3);
        scheduler.setThreadNamePrefix("nitso-exam-scheduler");
        scheduler.initialize();
        return scheduler;
    }

}
