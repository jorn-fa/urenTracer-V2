package jorn.hiel.urentracker.business;

import lombok.Getter;

public enum DayState {

    WERK(0),
    WEEKEND(3),
    VERLOF(2),
    ZIEK(4);


    @Getter
    private int value;

    DayState(int value) {
        this.value = value;
    }


}
