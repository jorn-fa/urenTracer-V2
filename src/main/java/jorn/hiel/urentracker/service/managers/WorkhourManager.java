package jorn.hiel.urentracker.service.managers;

import jorn.hiel.urentracker.business.DayState;
import jorn.hiel.urentracker.business.entities.ConfigDay;
import jorn.hiel.urentracker.business.entities.WorkDay;
import jorn.hiel.urentracker.repository.interfaces.ConfigDayRepository;
import jorn.hiel.urentracker.repository.interfaces.WorkDayRepository;
import jorn.hiel.urentracker.service.dto.ConfigDayDto;
import jorn.hiel.urentracker.service.dto.WorkDayDto;
import jorn.hiel.urentracker.service.mappers.ConfigDayMapper;
import jorn.hiel.urentracker.service.mappers.WorkDayMapper;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WorkhourManager {

 @Autowired
 private WorkDayRepository repo;

 @Autowired
 private ConfigDayRepository configRepo;

 @Autowired
 private WorkDayMapper mapper;

 @Autowired
 private ConfigDayMapper configMapper;

 private List<ConfigDay> configDays;

 @Getter
 private int minutesWorked=0;
 @Getter
 private int hoursWorked=0;
 @Getter
 private int minutesToWork=0;
@Getter
private int hoursToWork=0;



 void readConfig(){
  configDays=configRepo.findAll();
 }

 public List<ConfigDayDto> getConfigDayDtos(){
  readConfig();

  return configDays.stream().map(a-> configMapper.mapToDto(a)).collect(Collectors.toList());
 }

 public void addDay(WorkDayDto dto){

WorkDay day=mapper.mapToObj(dto);
WorkDay toSave;
Optional<WorkDay> workday = repo.findAll().stream().filter(a-> a.getDay().equals(day.getDay())).findFirst();

if(workday.isPresent()) {

 if (day.getWorked().equals(day.getWorked()) && day.getExtraWorked().equals(day.getExtraWorked())) {
  //update if values are different
  toSave= workday.get();
  toSave.setWorked(day.getWorked());
  toSave.setExtraWorked(day.getExtraWorked());
  repo.save(toSave);

 }
}
else {
 System.out.println("adding -> " + dto.toString());
 log.debug("adding -> " + dto.toString());
 repo.save(mapper.mapToObj(dto));
}

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

 public void calculateMaxToWork(int month,int year){
  if(configDays==null){readConfig();}

  int howMany = LocalDate.of(year,month,1).lengthOfMonth();

  for (ConfigDay config:configDays) {

   for (int day=1;day<=howMany;day++){
   LocalDate counter=LocalDate.of(year,month,day);
   if (config.getDag().equals(counter.getDayOfWeek().toString())) {


    hoursToWork+=config.getHours().getHour();
    minutesToWork+=config.getHours().getMinute();
    while (minutesToWork>=60){
     hoursToWork++;
     minutesToWork-=60;}
    }
   }
  }



 }

 public List<WorkDayDto> getMonth(int month, int year){
  if(configDays==null){readConfig();}
  List<WorkDay> workDays =  repo.findAll().stream()
          .filter(a -> a.getDay().getYear()==year)
          .filter(a -> a.getDay().getMonthValue()==month)
          .sorted(Comparator.comparing(WorkDay::getDay))
          .collect(Collectors.toList());

  workDays.forEach(this::calculateDifference);


 for (WorkDay workday:workDays){
      minutesWorked+=workday.getTotalWorked().getMinute();
      hoursWorked +=workday.getTotalWorked().getHour();
      while (minutesWorked>=60){
       hoursWorked++;
       minutesWorked-=60;
      }
  }

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

 /**
  * resets the counter for worked hour
  */
 public void clearWorked(){
  minutesWorked=0;
  hoursWorked=0;
 }

 /**
  * resets the counter for max hours to work
  */
 public void clearToWork(){
  minutesToWork=0;
  hoursToWork=0;
 }


 /**
  * corrects max to work with known workdays;
  * @param month List of WorkDayDto
  */
 public void processWorked(@NonNull List<WorkDayDto> month) {
for(WorkDayDto dto:month){
 if (dto.getDaystate()!=DayState.WERK){
  WorkDay workDay=mapper.mapToObj(dto);
  for(ConfigDay config:configDays){
    if (config.getDag().equals(workDay.getDay().getDayOfWeek().toString())){
   hoursToWork-=config.getHours().getHour();
   minutesToWork-=config.getHours().getMinute();
   }
  }
 }

}
 }

 public void updateConfig(List<ConfigDayDto> dtos) {
  dtos.stream()
          .map(a-> configMapper.mapToObj(a))
          .forEach(b->configRepo.save(b));
 }

 public String getDifference() {
  Duration min = Duration.ofHours(getHoursToWork()).plusMinutes(getMinutesToWork());
  Duration max = Duration.ofHours(getHoursWorked()).plusMinutes(getMinutesWorked());
  long hours= max.minus(min).toHours();
  long minutes =max.minus(min).toMinutesPart();
  if(hours<0 || minutes<0){

   return "-"+Math.abs(hours)+":"+String.format("%02d" , Math.abs(minutes))+" (short)";
  }

  return hours+":"+String.format("%02d" , Math.abs(minutes));
 }
}
