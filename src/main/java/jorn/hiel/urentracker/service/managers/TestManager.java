package jorn.hiel.urentracker.service.managers;

import jorn.hiel.urentracker.business.entities.ConfigDay;
import jorn.hiel.urentracker.business.entities.WorkDay;
import jorn.hiel.urentracker.repository.interfaces.ConfigDayRepository;
import jorn.hiel.urentracker.repository.interfaces.WorkDayRepository;
import jorn.hiel.urentracker.service.dto.WorkDayDto;
import jorn.hiel.urentracker.service.mappers.WorkDayMapper;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

 public void runMe(){

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
  log.debug("trying to remove -> " + dto.toString());
  WorkDay toRemove=mapper.mapToObj(dto);

  Optional<WorkDay>fromRepo =
  repo.findAll().stream().filter(a-> a.getDay().equals(toRemove.getDay())).findFirst();

  if(fromRepo.isPresent()){
   log.debug("removing ->" + fromRepo.toString());
   repo.delete(fromRepo.get());
  }



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

 public List<WorkDayDto> oldGetMonth(int month, int year){
  List<WorkDayDto> dtos = new ArrayList<>();

  repo.findAll().stream()
          .filter(a -> a.getDay().getYear()==year)
          .filter(a -> a.getDay().getMonthValue()==month)
          .forEach(a-> dtos.add(mapper.mapToDto(a)));
  return dtos;
 }

 public List<WorkDayDto> getMonth(int month, int year) {
  return repo.findAll().stream()
          .filter(a -> a.getDay().getYear()==year)
          .filter(a -> a.getDay().getMonthValue()==month)
          .map(a-> mapper.mapToDto(a))
          .collect(Collectors.toList());


 }


}
