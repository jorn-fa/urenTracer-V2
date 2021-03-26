package jorn.hiel.urentracker.business;

import lombok.Getter;

public enum DayState {

    WERK(0),
    WEEKEND(2),
    VERLOF(3),
    ZIEK(4);


    @Getter
    private int value;

    private DayState(int value) {
        this.value = value;
    }


}
