package com.api.library.application.Enum;

public enum Amount {
    AMOUNT_225(255),
    AMOUNT_100(100),
    AMOUNT_50(50),
    AMOUNT_20(20),
    AMOUNT_17(17),
    AMOUNT_15(15),
    AMOUNT_9(9);

    private final int value;

    private Amount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
