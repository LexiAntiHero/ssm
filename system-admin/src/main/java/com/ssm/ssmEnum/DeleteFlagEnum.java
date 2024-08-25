package com.ssm.ssmEnum;

public enum DeleteFlagEnum {
    YES("1"),NO("0");
    private String value;
    DeleteFlagEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
