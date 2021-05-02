package jorn.hiel.urentracker;

import jorn.hiel.urentracker.business.DayState;
import jorn.hiel.urentracker.business.entities.WorkDay;
import jorn.hiel.urentracker.service.mappers.WorkDayMapper;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class tester {


    public static void main(String[] args) {

        WorkDay workDay=new WorkDay().
                setDay(LocalDateTime.now())
                .setWorked(LocalTime.now())
                .setExtraWorked(LocalTime.now())
                .setDayState(DayState.VERLOF)
                ;
        System.out.println(workDay);
        WorkDayMapper mapper=new WorkDayMapper();

        System.out.println(mapper.mapToDto(workDay).getDay());






        }

}
