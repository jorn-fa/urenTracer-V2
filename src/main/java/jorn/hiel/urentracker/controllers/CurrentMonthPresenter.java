package jorn.hiel.urentracker.controllers;

import com.vaadin.flow.spring.annotation.SpringComponent;
import jorn.hiel.urentracker.service.managers.WorkhourManager;
import jorn.hiel.urentracker.views.showmycurrentmonth.ShowmycurrentmonthView;
import jorn.hiel.urentracker.views.urenconfig.UrenconfigView;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
@SpringComponent
public class CurrentMonthPresenter {

    @Autowired
    private WorkhourManager manager;
    @Setter
    private ShowmycurrentmonthView view;

    public void init() {

        view.getMonthField().addValueChangeListener(a-> readMonth());
        view.getYearField().addValueChangeListener(a-> readMonth());


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

    }
}