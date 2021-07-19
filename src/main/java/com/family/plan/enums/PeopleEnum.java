package com.family.plan.enums;

public enum PeopleEnum {
    LG("老公"),
    LP("老婆");

    private final String name;

    PeopleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
