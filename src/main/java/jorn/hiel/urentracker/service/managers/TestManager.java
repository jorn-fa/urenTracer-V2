package jorn.hiel.urentracker.service.managers;

import jorn.hiel.urentracker.business.DayState;
import jorn.hiel.urentracker.business.entities.ConfigDay;
import jorn.hiel.urentracker.business.entities.WorkDay;
import jorn.hiel.urentracker.repository.interfaces.ConfigDayRepository;
import jorn.hiel.urentracker.repository.interfaces.WorkDayRepository;
import jorn.hiel.urentracker.service.dto.WorkDayDto;
import jorn.hiel.urentracker.service.mappers.WorkDayMapper;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TestManager {

 @Autowired
 private WorkDayRepository repo;

 @Autowired
 private ConfigDayRepository configRepo;

 @Autowired
 private WorkDayMapper mapper;
 private List<ConfigDay> configDays;

 public void runMe(){

 }

 void readConfig(){
  configDays=configRepo.findAll();
 }

 public void addDay(WorkDayDto dto){
  log.debug("adding -> " + dto.toString());
  repo.save(mapper.mapToObj(dto));

 }

 /**
  * removes a day from the database if found in database
  * @param dto WorkDayDto
  */
 public void removeDay(@NonNull WorkDayDto dto){
  log.debug("trying to remove -> " + dto);
  WorkDay toRemove=mapper.mapToObj(dto);

  Optional<WorkDay>fromRepo = repo.findAll().stream().filter(a-> a.getDay().equals(toRemove.getDay())).findFirst();

  if(fromRepo.isPresent()){
   log.debug("removing ->" + fromRepo);
   repo.delete(fromRepo.get());
  }

 }

 public List<WorkDayDto> getMonth(int month, int year){
  if(configDays==null){readConfig();}
  List<WorkDay> workDays =  repo.findAll().stream()
          .filter(a -> a.getDay().getYear()==year)
          .filter(a -> a.getDay().getMonthValue()==month)
          .collect(Collectors.toList());

  workDays.forEach(this::calculateDifference);

  return workDays.stream().map(a-> mapper.mapToDto(a)).collect(Collectors.toList());
 }


/*
Fills in the missing data from preset week setup and calculates non
persisted values
 */

 void calculateDifference(WorkDay workDay){
  log.debug("calculating for " + workDay);

  if(workDay.getDayState()== DayState.WERK){

  for (ConfigDay config:configDays){

   if (config.getDag().equals(workDay.getDay().getDayOfWeek().toString())){
    workDay.setShouldWork(config.getHours());

    LocalTime calculatedWorked=workDay.getTotalWorked().minusNanos(workDay.getShouldWork().toNanoOfDay());

    if(workDay.getTotalWorked().isBefore(workDay.getShouldWork())){
     calculatedWorked=workDay.getShouldWork().minusNanos(workDay.getTotalWorked().toNanoOfDay());
     workDay.setToLowWorked(true);
    }

    workDay.setDifference(calculatedWorked );

   }
  }}

 }




}
