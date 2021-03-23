package jorn.hiel.urentracker.business.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter @Setter
@Accessors(chain = true)
@Entity
@Table(name = "werkuren")
@ToString
public class WorkDay extends BaseEntity {

    

    @Column(name = "datum")
    LocalDateTime day;

    @Column(name = "uren")
    LocalTime worked;

    @Column(name = "extraUren")
    LocalTime extraWorked;

    @Column(name = "detail")
    int detail;



}
