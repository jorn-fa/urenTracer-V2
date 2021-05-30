package jorn.hiel.urentracker;

import jorn.hiel.urentracker.business.DayState;
import jorn.hiel.urentracker.business.entities.WorkDay;
import jorn.hiel.urentracker.service.managers.WorkhourManager;
import jorn.hiel.urentracker.service.mappers.WorkDayMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class tester {


    public static void main(String[] args) {

        ApplicationContext app = SpringApplication.run(Application .class, args);//init

        WorkhourManager manager = app.getBean(WorkhourManager.class);//get the bean by type

        manager.getMonth(04,2021).stream().forEach(System.out::println);





        }

}
