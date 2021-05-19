package jorn.hiel.urentracker.service.mappers;

import jorn.hiel.urentracker.business.entities.ConfigDay;
import jorn.hiel.urentracker.service.dto.ConfigDayDto;
import jorn.hiel.urentracker.service.interfaces.BasicMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
@Service
public class ConfigDayMapper implements BasicMapper<ConfigDay, ConfigDayDto> {


    @Override
    public ConfigDay mapToObj(@NonNull ConfigDayDto dto) {
        return new ConfigDay()
                .setDag(dto.getDay())
                .setHours(LocalTime.parse(dto.getHours()));

    }

    @Override
    public ConfigDayDto mapToDto(@NonNull ConfigDay obj) {
        return new ConfigDayDto()
                .setDay(obj.getDag())
                .setHours(obj.getHours().toString());
    }
}
