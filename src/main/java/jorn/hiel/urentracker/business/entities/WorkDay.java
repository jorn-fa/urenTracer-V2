package jorn.hiel.urentracker.business.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@Accessors(chain = true)
@Entity
@Table(name = "werkuren")
public class WorkDay extends BaseEntity{


    LocalDateTime day;
    LocalTime worked;
    LocalTime extraWorked;



}
