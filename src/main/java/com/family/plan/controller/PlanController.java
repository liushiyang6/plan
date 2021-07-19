package com.family.plan.controller;

import com.family.plan.dao.HouseworkDao;
import com.family.plan.dao.PlanDao;
import com.family.plan.dao.PlanDetailsDao;
import com.family.plan.model.Housework;
import com.family.plan.model.Plan;
import com.family.plan.model.PlanDetails;
import com.family.plan.model.base.BaseDO;
import com.family.plan.response.PlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("plan")
public class PlanController {

    @Autowired
    private PlanDao planDao;
    @Autowired
    private PlanDetailsDao planDetailsDao;

    @Autowired
    private HouseworkDao houseworkDao;

    @RequestMapping("/index")
    public String index(Model model) {
        Plan plan = planDao.findTop1();
        List<Housework> houseworkList = houseworkDao.findAll();
        Map<Long, String> houseworkMap = houseworkList.stream().collect(Collectors.toMap(BaseDO::getId, Housework::getHName));
        PlanResponse planResponse = new PlanResponse();
        Long planId = plan.getId();
        List<PlanDetails> planDetailsList = planDetailsDao.findAllByPlanId(planId);
        ArrayList<PlanResponse.PlanDetailsResponse> planDetailsResponseList = new ArrayList<>();
        planDetailsList.forEach(planDetails -> {
            PlanResponse.PlanDetailsResponse planDetailsResponse = new PlanResponse.PlanDetailsResponse();
            planDetailsResponse.setPeopleName(planDetails.getPeople().getName());
            planDetailsResponse.setHouseworkName(houseworkMap.get(planDetails.getHouseworkId()));
            planDetailsResponseList.add(planDetailsResponse);
        });

        planResponse.setDistributeTimeStr(plan.getDistributeTime().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss")));
        planDetailsResponseList.sort(Comparator.comparing(PlanResponse.PlanDetailsResponse::getPeopleName));
        planResponse.setPlanDetailsResponseList(planDetailsResponseList);


        model.addAttribute("planResponse", planResponse);
        return "index";
    }
}
