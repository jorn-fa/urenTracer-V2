package jorn.hiel.urentracker.service.managers;

import jorn.hiel.urentracker.business.entities.ConfigDay;
import jorn.hiel.urentracker.business.entities.WorkDay;
import jorn.hiel.urentracker.repository.interfaces.ConfigDayRepository;
import jorn.hiel.urentracker.repository.interfaces.WorkDayRepository;
import jorn.hiel.urentracker.service.dto.WorkDayDto;
import jorn.hiel.urentracker.service.mappers.WorkDayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestManager {

 @Autowired
 private WorkDayRepository repo;

 @Autowired
 private ConfigDayRepository configRepo;

 @Autowired
 private WorkDayMapper mapper;

 public void runMe(){
  printAllDays();


 }

 public void addDay(WorkDayDto dto){

  repo.save(mapper.mapToObj(dto));

 }

 private void printAllDays(){
  for(WorkDay workday:repo.findAll()){
   System.out.println(workday);
  }
 }
 private void printConfig(){
  for(ConfigDay configDay:configRepo.findAll()){
   System.out.println(configDay);
  }
 }
}
