package com.family.plan.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PlanResponse {
    /**
     * 家務分配時間
     */
    private String distributeTimeStr;

    private List<PlanDetailsResponse> planDetailsResponseList;

    @Data
    public static class PlanDetailsResponse {

        /**
         * 家务ID
         */
        private String houseworkName;

        /**
         * 家務執行人
         */
        private String peopleName;

    }
}

