package jorn.hiel.urentracker;


import jorn.hiel.urentracker.repository.interfaces.WorkDayRepository;
import jorn.hiel.urentracker.service.managers.TestManager;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@Log4j2
public class Runner {




    public static void main(String[] args) {

        //SpringApplication.run(Runner.class, args);
        ApplicationContext app = SpringApplication.run(Application .class, args);//init
        TestManager manager = app.getBean(TestManager.class);//get the bean by type

        System.out.println(
                "running"
        );
        manager.runMe();
    }




}