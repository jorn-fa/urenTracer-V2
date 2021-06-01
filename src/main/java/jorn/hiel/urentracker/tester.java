package jorn.hiel.urentracker;

import jorn.hiel.urentracker.business.DayState;
import jorn.hiel.urentracker.business.entities.WorkDay;
import jorn.hiel.urentracker.service.dto.WorkDayDto;
import jorn.hiel.urentracker.service.managers.WorkhourManager;
import jorn.hiel.urentracker.service.mappers.WorkDayMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class tester {


    public static void main(String[] args) {

        WorkDayDto dto=new WorkDayDto();
        dto.setDay(LocalDateTime.now().toString());
        dto.setWorked("7:07");
        System.out.println(dto.getWorked().substring(1,2));

        if(dto.getWorked().substring(1,2).equals(":")){

            //dto.setWorked("0"+dto.getWorked());
            System.out.println(dto.getWorked());
        }
        else {
            System.out.println("did nothing");
        }
        dto.setExtraWorked("0:0");
        WorkDayMapper mapper=new WorkDayMapper();
        WorkDay day=mapper.mapToObj(dto);





        }

}
