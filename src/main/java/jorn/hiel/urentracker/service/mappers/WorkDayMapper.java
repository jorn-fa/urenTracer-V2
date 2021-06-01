package jorn.hiel.urentracker.service.mappers;

import jorn.hiel.urentracker.business.DayState;
import jorn.hiel.urentracker.business.entities.WorkDay;
import jorn.hiel.urentracker.service.dto.WorkDayDto;
import jorn.hiel.urentracker.service.interfaces.BasicMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class WorkDayMapper implements BasicMapper<WorkDay, WorkDayDto> {

    @Override
    public WorkDay mapToObj(@NonNull WorkDayDto dto) {
        if(!dto.getDaystate().equals(DayState.WERK)&&!dto.getDaystate().equals(DayState.WEEKEND)){
            dto.setWorked("00:00");
            dto.setExtraWorked(("00:00"));
        }

        if(dto.getWorked().substring(1,2).equals(":")){dto.setWorked("0"+dto.getWorked());}
        if(dto.getExtraWorked().substring(1,2).equals(":")){dto.setExtraWorked("0"+dto.getExtraWorked());}
        if(dto.getWorked().length()==4){dto.setWorked(dto.getWorked()+"0");}
        if(dto.getExtraWorked().length()==4){dto.setExtraWorked(dto.getExtraWorked()+"0");}


        return new WorkDay()
                .setDay(LocalDateTime.parse(dto.getDay()))
                .setWorked(LocalTime.parse(dto.getWorked()))
                .setExtraWorked(LocalTime.parse(dto.getExtraWorked()))
                .setDayState(dto.getDaystate())
                ;
    }

    @Override
    public WorkDayDto mapToDto(@NonNull WorkDay obj) {

        return new WorkDayDto()
                .setDay(obj.getDay().toString())
                .setWorked(obj.getWorked().toString())
                .setExtraWorked(obj.getExtraWorked().toString())
                .setDaystate(obj.getDayState())
                .setTotalWorked(obj.getTotalWorked().toString())
                .setToWork(obj.getShouldWork().toString())
                .setDifference(obj.getDifference().toString())
                .setToLow(obj.isToLowWorked());

    }
}
