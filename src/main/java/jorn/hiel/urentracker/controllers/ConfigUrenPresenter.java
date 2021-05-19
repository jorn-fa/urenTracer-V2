package jorn.hiel.urentracker.controllers;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.spring.annotation.SpringComponent;
import jorn.hiel.urentracker.service.dto.ConfigDayDto;
import jorn.hiel.urentracker.service.managers.WorkhourManager;
import jorn.hiel.urentracker.views.urenconfig.UrenconfigView;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@SpringComponent
public class ConfigUrenPresenter   {


    @Autowired
    private WorkhourManager manager;
    @Setter
    private UrenconfigView view;

public void init(){
    view.getUpdateButton().addClickListener(e -> {
        Notification.show("-Updating-");
        manager.updateConfig(createDtos());
    });
    updateFields();
}


    public List<ConfigDayDto> createDtos(){
        List<ConfigDayDto>dtos=new ArrayList<>();
        dtos.add(new ConfigDayDto().setDay("MONDAY").setHours(view.getMaandagTextField().getValue()));
        dtos.add(new ConfigDayDto().setDay("TUESDAY").setHours(view.getDinsdagTextField().getValue()));
        dtos.add(new ConfigDayDto().setDay("WEDNESDAY").setHours(view.getWoensdagTextField().getValue()));
        dtos.add(new ConfigDayDto().setDay("THURSDAY").setHours(view.getDonderdagTextField().getValue()));
        dtos.add(new ConfigDayDto().setDay("FRIDAY").setHours(view.getVrijdagTextField().getValue()));
        dtos.add(new ConfigDayDto().setDay("SATURDAY").setHours(view.getZaterdagTextField().getValue()));
        dtos.add(new ConfigDayDto().setDay("SUNDAY").setHours(view.getZondagTextField().getValue()));
        return dtos;

    }

    private void updateFields(){
        List<ConfigDayDto>dtos = manager.getConfigDayDtos();
        view.getMaandagTextField().setValue(getConfigDto(dtos,"monday").getHours());
        view.getDinsdagTextField().setValue(getConfigDto(dtos,"tuesday").getHours());
        view.getWoensdagTextField().setValue(getConfigDto(dtos,"wednesday").getHours());
        view.getDonderdagTextField().setValue(getConfigDto(dtos,"thursday").getHours());
        view.getVrijdagTextField().setValue(getConfigDto(dtos,"friday").getHours());
        view.getZaterdagTextField().setValue(getConfigDto(dtos,"saturday").getHours());
        view.getZondagTextField().setValue(getConfigDto(dtos,"sunday").getHours());
    }

    private ConfigDayDto getConfigDto(List<ConfigDayDto> dtos, String day){
        return dtos.stream().filter(a-> a.getDay().equals(day.trim().toUpperCase(Locale.ROOT))).findFirst().get();
    }


}
