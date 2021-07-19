package com.family.plan.service;

import cn.hutool.core.util.RandomUtil;
import com.family.plan.dao.HouseworkDao;
import com.family.plan.dao.PlanDao;
import com.family.plan.dao.PlanDetailsDao;
import com.family.plan.enums.PeopleEnum;
import com.family.plan.model.Housework;
import com.family.plan.model.Plan;
import com.family.plan.model.PlanDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {
    private final HouseworkDao houseworkDao;

    private final PlanDao planDao;

    private final PlanDetailsDao planDetailsDao;

    public PlanService(HouseworkDao houseworkDao, PlanDao planDao, PlanDetailsDao planDetailsDao) {
        this.houseworkDao = houseworkDao;
        this.planDao = planDao;
        this.planDetailsDao = planDetailsDao;
    }

    public void distributeHousework() {
        List<Housework> allHousework = houseworkDao.findAll();
        List<PlanDetails> planDetailsList = new ArrayList<>();
        Plan plan = new Plan();
        plan.setDistributeTime(LocalDateTime.now());
        Plan savePlan = planDao.save(plan);

        List<Housework> randomEleList = RandomUtil.randomEleList(allHousework, allHousework.size() / 2);

        int[] ints = RandomUtil.randomInts(2);

        allHousework.forEach(housework -> {
            PlanDetails planDetails = new PlanDetails();
            planDetails.setHouseworkId(housework.getId());
            if (randomEleList.contains(housework)) {
                planDetails.setPeople(PeopleEnum.values()[ints[0]]);
            } else {
                planDetails.setPeople(PeopleEnum.values()[ints[1]]);
            }
            planDetails.setPlanId(savePlan.getId());
            planDetailsList.add(planDetails);
        });


        planDetailsDao.saveAll(planDetailsList);
    }


}
