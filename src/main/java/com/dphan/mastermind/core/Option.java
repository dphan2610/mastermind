package com.dphan.mastermind.core;

public enum Option {

    CUSTOM("0"),
    AUTO_GENERATED("1");

    private String code;

    private Option(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Option fromString(String code) {
        for (Option option : Option.values()) {
            if (option.getCode().equals(code)) {
                return option;
            }
        }
        throw new IllegalArgumentException("Option code " + code + " not recognized.");
    }
}
