package com.beBrave.admin.entity;

public enum InventoryLocation {

    ROASTING_ROOM_SHELF("로스팅 룸 선반"),
    FREEZER("냉동고"),
    DISPLAY_RACK("진열대"),
    BREWING_BAR_BOTTOM("브루잉 바 하단"),
    SECOND_FLOOR_STORAGE("2층 창고"),
    OFFICE("사무실"),
    STAIRS("계단");

    private final String value;

    InventoryLocation(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static InventoryLocation fromValue(String value) {
        for (InventoryLocation location : InventoryLocation.values()) {
            if (location.value.equals(value)) {
                return location;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }

}
