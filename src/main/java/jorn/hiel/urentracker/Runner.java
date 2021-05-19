package jorn.hiel.urentracker;


import jorn.hiel.urentracker.controllers.ConfigUrenPresenter;
import jorn.hiel.urentracker.service.dto.ConfigDayDto;
import jorn.hiel.urentracker.service.dto.WorkDayDto;
import jorn.hiel.urentracker.service.managers.WorkhourManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Locale;


@SpringBootApplication
@Log4j2
public class Runner {



    public static void main(String[] args) {

        //SpringApplication.run(Runner.class, args);
        ApplicationContext app = SpringApplication.run(Application .class, args);//init

        WorkhourManager manager = app.getBean(WorkhourManager.class);//get the bean by type












    }




}