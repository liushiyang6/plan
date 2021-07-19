package com.family.plan.task;

import com.family.plan.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
@Slf4j
public class PlanTask {

    private final PlanService planService;

    public PlanTask(PlanService planService) {
        this.planService = planService;
    }

    @Scheduled(cron = "0 0 21 ? * SUN")
    public void taskDistributeHousework() {
        log.info("开始执行家务分配...");
        planService.distributeHousework();
    }
}
