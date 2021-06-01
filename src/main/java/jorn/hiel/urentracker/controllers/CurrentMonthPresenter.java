package jorn.hiel.urentracker.controllers;

import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import jorn.hiel.urentracker.business.DayState;
import jorn.hiel.urentracker.service.dto.WorkDayDto;
import jorn.hiel.urentracker.service.managers.WorkhourManager;
import jorn.hiel.urentracker.views.showmycurrentmonth.ShowmycurrentmonthView;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;


@SpringComponent
public class CurrentMonthPresenter {

    @Autowired
    private WorkhourManager manager;
    @Setter
    private ShowmycurrentmonthView view;

    public void init() {

        view.getMonthField().addValueChangeListener(a-> readMonth());
        view.getYearField().addValueChangeListener(a-> readMonth());


        for(int dag=0;dag<=30;dag++){
            addCombo(view.getFields().get(dag),view.getExtras().get(dag));
        }
        view.getUpdate().addClickListener(a-> saveMonth());


        readMonth();
    }



    private void addCombo(TextField start, TextField follower){
        start.addValueChangeListener(b-> {
            view.getDay1Extra().setRequired(true);
            follower.focus();});


    }

    private WorkDayDto createDto(int day){
        WorkDayDto dto=new WorkDayDto();
        dto.setWorked(view.getFields().get(day).getValue());
        dto.setExtraWorked(view.getExtras().get(day).getValue());
        dto.setDaystate(DayState.valueOf(view.getStates().get(day).getValue().toString()));
        LocalDateTime filter=LocalDateTime.of(view.getYearField().getValue().intValue(),view.getMonthField().getValue().intValue(),day+1,0,0);

        dto.setDay(filter.toString());
        return dto;
    }

    private void saveMonth(){
        for(int day=0;day<=30;day++){
            if(view.getFields().get(day).isVisible()){
                DayState check = DayState.valueOf(view.getStates().get(day).getValue().toString());
                if(!check.equals(DayState.WERK)&!check.equals(DayState.WEEKEND)||!view.getFields().get(day).isEmpty()&&!view.getExtras().get(day).isEmpty())
                {
                    manager.addDay(createDto(day));
                }
            }
        }
        readMonth();

    }



    private void readMonth() {
        int month = view.getMonthField().getValue().intValue();
        int year = view.getYearField().getValue().intValue();


        manager.clearToWork();
        manager.clearWorked();

        manager.calculateMaxToWork(month,year);
        manager.processWorked(manager.getMonth(month,year));

        view.getToWork().setValue(manager.getHoursToWork() + " : " + manager.getMinutesToWork());
        view.getMaxWork().setValue((manager.getHoursWorked() + " : " + manager.getMinutesWorked()));
        view.getResultWorked().setValue(manager.getDifference());

        view.setMonth(month);
        view.setYear(year);
        view.updateLabels();
        view.verifyEndOfMonth();


        try {
            parseMonth(manager.getMonth(month, year));
        } catch (Exception e) {
            System.out.println("cannot retrieve non existing");


        }

    }



    private void parseMonth(List<WorkDayDto> month) {
        view.getFields().forEach(HasValue::clear);
        view.getFields().forEach(x->x.setInvalid(false));

        view.getExtras().forEach(HasValue::clear);
        view.getExtras().forEach(x->x.setInvalid(false));


        for(WorkDayDto dto:month){
            int day = LocalDateTime.parse(dto.getDay()).getDayOfMonth()-1;
            view.getFields().get(day).setValue(dto.getWorked());
            view.getExtras().get(day).setValue(dto.getExtraWorked());
            view.getStates().get(day).setValue(dto.getDaystate());
        }



    }


}