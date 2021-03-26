package jorn.hiel.urentracker.business.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import jorn.hiel.urentracker.business.DayState;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author Hiel Jorn
 * @version 1.0
 * <p>
 *     pojo to hold a work day details
 *     including day and hours worked and if any extra hours
 * </p>
 */

@Getter @Setter
@Accessors(chain = true)
@Entity
@Table(name = "werkuren")
@ToString
public class WorkDay extends BaseEntity {

    private DayState dayState;

    @Column(name = "datum")
    private LocalDateTime day;

    @Column(name = "uren")
    private LocalTime worked;

    @Column(name = "extraUren")
    private LocalTime extraWorked;

    @Column(name = "detail")
    @Setter(value = AccessLevel.NONE)
    @Getter(value = AccessLevel.NONE)
    private int detail;

    /**
     *
     * @return DayState based on int value in detail
     */

    public DayState getDayState(){
        for(DayState state: DayState.values()){
            if (state.getValue() == this.detail) {
                this.dayState=state;
                return state;
            }}

        return DayState.WERK;
    }


}
