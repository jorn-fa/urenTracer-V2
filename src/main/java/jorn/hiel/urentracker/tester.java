package jorn.hiel.urentracker;

import jorn.hiel.urentracker.business.DayState;
import jorn.hiel.urentracker.business.entities.WorkDay;
import jorn.hiel.urentracker.service.mappers.WorkDayMapper;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class tester {


    public static void main(String[] args) {

        WorkDay workDay=new WorkDay()
                .setDay(LocalDateTime.of(2021,5,5,0,0))
                .setWorked(LocalTime.of(8,5))
                .setExtraWorked(LocalTime.of(0,45))
                .setDayState(DayState.VERLOF)
                ;
        System.out.println(workDay);
        WorkDayMapper mapper=new WorkDayMapper();

        System.out.println(mapper.mapToDto(workDay).getDay());






        }

}
