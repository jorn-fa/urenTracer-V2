package jorn.hiel.urentracker.service.dto;

import jorn.hiel.urentracker.business.DayState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public final class WorkDayDto {

    DayState daystate;
    String day,worked, extraWorked,totalWorked,toWork;


}
