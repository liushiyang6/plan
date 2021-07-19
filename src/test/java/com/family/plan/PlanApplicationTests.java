package com.family.plan;

import com.family.plan.service.PlanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlanApplicationTests {

    @Autowired
    PlanService planService;

    @Test
    void contextLoads() {
        planService.distributeHousework();
    }

}
