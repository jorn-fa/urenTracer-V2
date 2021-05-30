package jorn.hiel.urentracker.views.showmycurrentmonth;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import jorn.hiel.urentracker.business.DayState;
import jorn.hiel.urentracker.controllers.CurrentMonthPresenter;
import jorn.hiel.urentracker.helpers.TextFieldPatterns;
import jorn.hiel.urentracker.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.dependency.CssImport;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

@Route(value = "current", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Show my current month")
@CssImport("./views/showmycurrentmonth/showmycurrentmonth-view.css")
@Getter
@Setter
@SpringComponent
@UIScope
public class ShowmycurrentmonthView extends HorizontalLayout {

    @Autowired
    CurrentMonthPresenter presenter;

    private TextField toWork,maxWork,resultWorked;
    private TextField day1Worked,day2Worked,day3Worked,day4Worked,day5Worked,day6Worked,day7Worked,day8Worked,day9Worked,day10Worked,day11Worked,day12Worked,day13Worked,day14Worked,day15Worked,day16Worked,day17Worked,day18Worked,day19Worked,day20Worked,day21Worked,day22Worked,day23Worked,day24Worked,day25Worked,day26Worked,day27Worked,day28Worked,day29Worked,day30Worked,day31Worked;
    private TextField day1Extra,day2Extra,day3Extra,day4Extra,day5Extra,day6Extra,day7Extra,day8Extra,day9Extra,day10Extra,day11Extra,day12Extra,day13Extra,day14Extra,day15Extra,day16Extra,day17Extra,day18Extra,day19Extra,day20Extra,day21Extra,day22Extra,day23Extra,day24Extra,day25Extra,day26Extra,day27Extra,day28Extra,day29Extra,day30Extra,day31Extra;
    private TextField day1Detail,day2Detail,day3Detail,day4Detail,day5Detail,day6Detail,day7Detail,day8Detail,day9Detail,day10Detail,day11Detail,day12Detail,day13Detail,day14Detail,day15Detail,day16Detail,day17Detail,day18Detail,day19Detail,day20Detail,day21Detail,day22Detail,day23Detail,day24Detail,day25Detail,day26Detail,day27Detail,day28Detail,day29Detail,day30Detail,day31Detail;
    private Select<DayState> day1State,day2State,day3State,day4State,day5State,day6State,day7State,day8State,day9State,day10State,day11State,day12State,day13State,day14State,day15State,day16State,day17State,day18State,day19State,day20State,day21State,day22State,day23State,day24State,day25State,day26State,day27State,day28State,day29State,day30State,day31State;






    private NumberField monthField;
    private NumberField yearField;
        private double month;
        private double year;

    private List<TextField> fields,extras,details;
    private List<Select>states;


    @PostConstruct
    public void init(){


        presenter.setView(this);
        presenter.init();
        fields.forEach(this::setCommon);
        extras.forEach(this::setCommon);
    }


    public ShowmycurrentmonthView() {
        addClassName("showmycurrentmonth-view");
        //create fields
        createWorked();
        createExtra();
        createDetails();
        createStates();
        fields = Arrays.asList(day1Worked,day2Worked,day3Worked,day4Worked,day5Worked,day6Worked,day7Worked,day8Worked,day9Worked,day10Worked,day11Worked,day12Worked,day13Worked,day14Worked,day15Worked,day16Worked,day17Worked,day18Worked,day19Worked,day20Worked,day21Worked,day22Worked,day23Worked,day24Worked,day25Worked,day26Worked,day27Worked,day28Worked,day29Worked,day30Worked,day31Worked);
        extras = Arrays.asList(day1Extra,day2Extra,day3Extra,day4Extra,day5Extra,day6Extra,day7Extra,day8Extra,day9Extra,day10Extra,day11Extra,day12Extra,day13Extra,day14Extra,day15Extra,day16Extra,day17Extra,day18Extra,day19Extra,day20Extra,day21Extra,day22Extra,day23Extra,day24Extra,day25Extra,day26Extra,day27Extra,day28Extra,day29Extra,day30Extra,day31Extra);
        details = Arrays.asList(day1Detail,day2Detail,day3Detail,day4Detail,day5Detail,day6Detail,day7Detail,day8Detail,day9Detail,day10Detail,day11Detail,day12Detail,day13Detail,day14Detail,day15Detail,day16Detail,day17Detail,day18Detail,day19Detail,day20Detail,day21Detail,day22Detail,day23Detail,day24Detail,day25Detail,day26Detail,day27Detail,day28Detail,day29Detail,day30Detail,day31Detail);
        states = Arrays.asList(day1State,day2State,day3State,day4State,day5State,day6State,day7State,day8State,day9State,day10State,day11State,day12State,day13State,day14State,day15State,day16State,day17State,day18State,day19State,day20State,day21State,day22State,day23State,day24State,day25State,day26State,day27State,day28State,day29State,day30State,day31State);




        month=LocalDate.now().getMonthValue();
        year=LocalDate.now().getYear();


        monthField = new NumberField();
        yearField = new NumberField();

        monthField.setValue(month);
        yearField.setValue(year);


        monthField.setHasControls(true);
        monthField.setMax(12D);
        monthField.setMin((1D));
        yearField.setHasControls(true);

        add(monthField);
        add(yearField);
        toWork = new TextField("To work");
        maxWork= new TextField("Worked");
        resultWorked= new TextField("Result");
        add(toWork);
        add(maxWork);
        add(resultWorked);

        FormLayout form = new FormLayout();
        add(form);



        VerticalLayout layout= new VerticalLayout();
        form.add(layout);


        layout.add(addToLayout(day1Detail,day1Worked,day1Extra,fillSelect(day1State,day1Detail)));
        layout.add(addToLayout(day2Detail,day2Worked,day2Extra,fillSelect(day2State,day2Detail)));
        layout.add(addToLayout(day3Detail,day3Worked,day3Extra,fillSelect(day3State,day3Detail)));
        layout.add(addToLayout(day4Detail,day4Worked,day4Extra,fillSelect(day4State,day4Detail)));
        layout.add(addToLayout(day5Detail,day5Worked,day5Extra,fillSelect(day5State,day5Detail)));
        layout.add(addToLayout(day6Detail,day6Worked,day6Extra,fillSelect(day6State,day6Detail)));
        layout.add(addToLayout(day7Detail,day7Worked,day7Extra,fillSelect(day7State,day7Detail)));
        layout.add(addToLayout(day8Detail,day8Worked,day8Extra,fillSelect(day8State,day8Detail)));
        layout.add(addToLayout(day9Detail,day9Worked,day9Extra,fillSelect(day9State,day9Detail)));
        layout.add(addToLayout(day10Detail,day10Worked,day10Extra,fillSelect(day10State,day10Detail)));
        layout.add(addToLayout(day11Detail,day11Worked,day11Extra,fillSelect(day11State,day11Detail)));
        layout.add(addToLayout(day12Detail,day12Worked,day12Extra,fillSelect(day12State,day12Detail)));
        layout.add(addToLayout(day13Detail,day13Worked,day13Extra,fillSelect(day13State,day13Detail)));
        layout.add(addToLayout(day14Detail,day14Worked,day14Extra,fillSelect(day14State,day14Detail)));
        layout.add(addToLayout(day15Detail,day15Worked,day15Extra,fillSelect(day15State,day15Detail)));
        layout.add(addToLayout(day16Detail,day16Worked,day16Extra,fillSelect(day16State,day16Detail)));
        layout.add(addToLayout(day17Detail,day17Worked,day17Extra,fillSelect(day17State,day17Detail)));
        layout.add(addToLayout(day18Detail,day18Worked,day18Extra,fillSelect(day18State,day18Detail)));
        layout.add(addToLayout(day19Detail,day19Worked,day19Extra,fillSelect(day19State,day19Detail)));
        layout.add(addToLayout(day20Detail,day20Worked,day20Extra,fillSelect(day20State,day20Detail)));
        layout.add(addToLayout(day21Detail,day21Worked,day21Extra,fillSelect(day21State,day21Detail)));
        layout.add(addToLayout(day22Detail,day22Worked,day22Extra,fillSelect(day22State,day22Detail)));
        layout.add(addToLayout(day23Detail,day23Worked,day23Extra,fillSelect(day23State,day23Detail)));
        layout.add(addToLayout(day24Detail,day24Worked,day24Extra,fillSelect(day24State,day24Detail)));
        layout.add(addToLayout(day25Detail,day25Worked,day25Extra,fillSelect(day25State,day25Detail)));
        layout.add(addToLayout(day26Detail,day26Worked,day26Extra,fillSelect(day26State,day26Detail)));
        layout.add(addToLayout(day27Detail,day27Worked,day27Extra,fillSelect(day27State,day27Detail)));
        layout.add(addToLayout(day28Detail,day28Worked,day28Extra,fillSelect(day28State,day28Detail)));

        layout.add(addToLayout(day29Detail, day29Worked, day29Extra, fillSelect(day29State, day29Detail)));
        layout.add(addToLayout(day30Detail, day30Worked, day30Extra, fillSelect(day30State, day30Detail)));
        layout.add(addToLayout(day31Detail, day31Worked, day31Extra, fillSelect(day31State, day31Detail)));
        verifyEndOfMonth();

        updateLabels();


    }

    public void verifyEndOfMonth() {
        LocalDate filter=LocalDate.of(yearField.getValue().intValue(),monthField.getValue().intValue(),1);


        if (filter.lengthOfMonth()==30) {
            day31Detail.setVisible(false);
            day31Worked.setVisible(false);
            day31Extra.setVisible(false);
            day31State.setVisible(false);
        }

        if (filter.lengthOfMonth()==28) {
            day31Detail.setVisible(false);
            day31Worked.setVisible(false);
            day31Extra.setVisible(false);
            day31State.setVisible(false);
            day30Detail.setVisible(false);
            day30Worked.setVisible(false);
            day30Extra.setVisible(false);
            day30State.setVisible(false);
            day29Detail.setVisible(false);
            day29Worked.setVisible(false);
            day29Extra.setVisible(false);
            day29State.setVisible(false);

        }
    }


    public void updateLabels(){
        for (int day=1;day<=31;day++){
            details.get(day-1).setValue(createLabel(day));
            states.get(day-1).setValue(DayState.WERK);
            if(details.get(day-1).getValue().contains("sat")||
                    details.get(day-1).getValue().contains("sun")){
                states.get(day-1).setValue(DayState.WEEKEND);
            }


        }

    }



    private Select<DayState> fillSelect(Select<DayState> select,TextField field){
        if (select==null){select=new Select<>();}
        select.setItems(DayState.WERK,DayState.VERLOF,DayState.ZIEK,DayState.WEEKEND);
        select.setValue(DayState.WERK);
        if(field.getValue().contains("satur")||field.getValue().contains("sund")){
            select.setValue(DayState.WEEKEND);
        }
        return select;
    }

    private HorizontalLayout addToLayout(TextField label, TextField fieldOne, TextField fieldTwo, Select<DayState> selectBox){
        HorizontalLayout layout= new HorizontalLayout();
        fieldOne.setLabel("");
        layout.add(label,fieldOne,fieldTwo,selectBox);
        return layout;
    }
private TextField setCommon(TextField field) {
    field.setPlaceholder("00:00");
    field.setMaxLength(5);
    field.setMinLength(5);
    field.setPattern(TextFieldPatterns.HOURPATTERN);
    return field;
}
private String createLabel(int day){
        try {return (LocalDate.of((int)year,(int)month,day).getDayOfWeek().name().toLowerCase(Locale.ROOT))+" " + day;}
        catch(DateTimeException e){


        return "next month";
        }
    }

    private void createWorked(){
        day1Worked= new TextField();
        day2Worked= new TextField();
        day3Worked= new TextField();
        day4Worked= new TextField();
        day5Worked= new TextField();
        day6Worked= new TextField();
        day7Worked= new TextField();
        day8Worked= new TextField();
        day9Worked= new TextField();
        day10Worked= new TextField();
        day11Worked= new TextField();
        day12Worked= new TextField();
        day13Worked= new TextField();
        day14Worked= new TextField();
        day15Worked= new TextField();
        day16Worked= new TextField();
        day17Worked= new TextField();
        day18Worked= new TextField();
        day19Worked= new TextField();
        day20Worked= new TextField();
        day21Worked= new TextField();
        day22Worked= new TextField();
        day23Worked= new TextField();
        day24Worked= new TextField();
        day25Worked= new TextField();
        day26Worked= new TextField();
        day27Worked= new TextField();
        day28Worked= new TextField();
        day29Worked= new TextField();
        day30Worked= new TextField();
        day31Worked= new TextField();
    }

    private void createExtra(){
        day1Extra= new TextField();
        day2Extra= new TextField();
        day3Extra= new TextField();
        day4Extra= new TextField();
        day5Extra= new TextField();
        day6Extra= new TextField();
        day7Extra= new TextField();
        day8Extra= new TextField();
        day9Extra= new TextField();
        day10Extra= new TextField();
        day11Extra= new TextField();
        day12Extra= new TextField();
        day13Extra= new TextField();
        day14Extra= new TextField();
        day15Extra= new TextField();
        day16Extra= new TextField();
        day17Extra= new TextField();
        day18Extra= new TextField();
        day19Extra= new TextField();
        day20Extra= new TextField();
        day21Extra= new TextField();
        day22Extra= new TextField();
        day23Extra= new TextField();
        day24Extra= new TextField();
        day25Extra= new TextField();
        day26Extra= new TextField();
        day27Extra= new TextField();
        day28Extra= new TextField();
        day29Extra= new TextField();
        day30Extra= new TextField();
        day31Extra= new TextField();
    }
    private void createDetails(){
        day1Detail= new TextField();
        day2Detail= new TextField();
        day3Detail= new TextField();
        day4Detail= new TextField();
        day5Detail= new TextField();
        day6Detail= new TextField();
        day7Detail= new TextField();
        day8Detail= new TextField();
        day9Detail= new TextField();
        day10Detail= new TextField();
        day11Detail= new TextField();
        day12Detail= new TextField();
        day13Detail= new TextField();
        day14Detail= new TextField();
        day15Detail= new TextField();
        day16Detail= new TextField();
        day17Detail= new TextField();
        day18Detail= new TextField();
        day19Detail= new TextField();
        day20Detail= new TextField();
        day21Detail= new TextField();
        day22Detail= new TextField();
        day23Detail= new TextField();
        day24Detail= new TextField();
        day25Detail= new TextField();
        day26Detail= new TextField();
        day27Detail= new TextField();
        day28Detail= new TextField();
        day29Detail= new TextField();
        day30Detail= new TextField();
        day31Detail= new TextField();
    }

    private void createStates(){
        day1State= new Select<>();
        day2State= new Select<>();
        day3State= new Select<>();
        day4State= new Select<>();
        day5State= new Select<>();
        day6State= new Select<>();
        day7State= new Select<>();
        day8State= new Select<>();
        day9State= new Select<>();
        day10State= new Select<>();
        day11State= new Select<>();
        day12State= new Select<>();
        day13State= new Select<>();
        day14State= new Select<>();
        day15State= new Select<>();
        day16State= new Select<>();
        day17State= new Select<>();
        day18State= new Select<>();
        day19State= new Select<>();
        day20State= new Select<>();
        day21State= new Select<>();
        day22State= new Select<>();
        day23State= new Select<>();
        day24State= new Select<>();
        day25State= new Select<>();
        day26State= new Select<>();
        day27State= new Select<>();
        day28State= new Select<>();
        day29State= new Select<>();
        day30State= new Select<>();
        day31State= new Select<>();
    }
}
