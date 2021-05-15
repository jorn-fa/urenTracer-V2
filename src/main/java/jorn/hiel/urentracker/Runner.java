package jorn.hiel.urentracker;


import jorn.hiel.urentracker.service.dto.WorkDayDto;
import jorn.hiel.urentracker.service.managers.TestManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
@Log4j2
public class Runner {



    public static void main(String[] args) {

        //SpringApplication.run(Runner.class, args);
        ApplicationContext app = SpringApplication.run(Application .class, args);//init

        TestManager manager = app.getBean(TestManager.class);//get the bean by type

        List<WorkDayDto> month=
        manager.getMonth(4,2021);

        //month.forEach(System.out::println);

        manager.calculateMaxToWork(4,2021);
        manager.processWorked(month);

        //manager.getMonth(4,2021);
        System.out.println("worked -> " + manager.getHoursWorked()+":"+manager.getMinutesWorked());
        System.out.println("to work -> " + manager.getHoursToWork()+":"+ manager.getMinutesToWork());










    }




}