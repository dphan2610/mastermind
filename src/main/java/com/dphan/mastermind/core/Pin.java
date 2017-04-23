package com.dphan.mastermind.core;

public enum Pin {

    BLACK("P"),
    WHITE("C");

    private String code;

    private Pin(String code) {
        this.code = code;
    }
}
