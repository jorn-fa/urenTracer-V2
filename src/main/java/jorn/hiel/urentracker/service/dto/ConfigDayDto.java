package jorn.hiel.urentracker.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalTime;


@Getter
@Setter
@Accessors(chain = true)
@ToString
public class ConfigDayDto {

    private String day;
    private String hours;

}
