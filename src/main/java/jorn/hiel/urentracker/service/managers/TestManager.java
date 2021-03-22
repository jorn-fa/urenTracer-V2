package jorn.hiel.urentracker.service.managers;

import jorn.hiel.urentracker.repository.interfaces.WorkDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TestManager {

 @Autowired
 private WorkDayRepository repo;

 public void runMe(){
  System.out.println("found items ?");
  System.out.println(repo==null);
  System.out.println(repo.findAll().size() + " items found");

 }

}
