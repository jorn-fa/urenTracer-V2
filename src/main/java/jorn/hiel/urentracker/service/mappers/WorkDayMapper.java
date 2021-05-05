package jorn.hiel.urentracker.service.mappers;

import jorn.hiel.urentracker.business.entities.WorkDay;
import jorn.hiel.urentracker.service.dto.WorkDayDto;
import jorn.hiel.urentracker.service.interfaces.BasicMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
@Service
public class WorkDayMapper implements BasicMapper<WorkDay, WorkDayDto> {

    @Override
    public WorkDay mapToObj(@NonNull WorkDayDto dto) {
        return new WorkDay()
                .setDay(LocalDateTime.parse(dto.getDay()))
                .setWorked(LocalTime.parse(dto.getWorked()))
                .setExtraWorked(LocalTime.parse(dto.getExtraworked()))
                .setDayState(dto.getDaystate());
    }

    @Override
    public WorkDayDto mapToDto(@NonNull WorkDay obj) {
        return new WorkDayDto()
                .setDay(obj.getDay().toString())
                .setWorked(obj.getWorked().toString())
                .setExtraworked(obj.getExtraWorked().toString())
                .setDaystate(obj.getDayState());
    }
}
