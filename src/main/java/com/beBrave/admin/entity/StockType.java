package com.beBrave.admin.entity;

public enum StockType {
    INBOUND(0),OUTBOUND(1);

    private final int value;

    StockType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
