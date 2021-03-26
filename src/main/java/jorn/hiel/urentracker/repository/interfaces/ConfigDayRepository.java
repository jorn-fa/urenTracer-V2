package jorn.hiel.urentracker.repository.interfaces;

import jorn.hiel.urentracker.business.entities.ConfigDay;
import jorn.hiel.urentracker.business.entities.WorkDay;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigDayRepository extends CrudRepository<ConfigDay, Long> {

    List<ConfigDay> findAll();


}