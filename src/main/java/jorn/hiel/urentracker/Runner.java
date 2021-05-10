package jorn.hiel.urentracker;


import jorn.hiel.urentracker.business.DayState;
import jorn.hiel.urentracker.business.entities.WorkDay;
import jorn.hiel.urentracker.repository.interfaces.WorkDayRepository;
import jorn.hiel.urentracker.service.managers.TestManager;
import jorn.hiel.urentracker.service.mappers.WorkDayMapper;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.time.LocalTime;


@SpringBootApplication
@Log4j2
public class Runner {



    public static void main(String[] args) {

        //SpringApplication.run(Runner.class, args);
        ApplicationContext app = SpringApplication.run(Application .class, args);//init


        TestManager manager = app.getBean(TestManager.class);//get the bean by type
        WorkDayMapper mapper = app.getBean(WorkDayMapper.class);





        System.out.println(
                "running"
        );
//        manager.runMe();

        /*WorkDay workDay=new WorkDay()
                .setDay(LocalDateTime.of(2021,5,5,0,0))
                .setWorked(LocalTime.of(8,5))
                .setExtraWorked(LocalTime.of(0,45))
                .setDayState(DayState.VERLOF)
                ;*/

//        manager.removeDay(mapper.mapToDto(workDay));

        //System.out.println(manager.getMonth(01,2021).size());
        manager.getMonth(1,2021).forEach(System.out::println);

        manager.runMe();







    }




}