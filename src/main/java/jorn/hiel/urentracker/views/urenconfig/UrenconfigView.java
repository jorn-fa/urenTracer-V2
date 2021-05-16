package jorn.hiel.urentracker.views.urenconfig;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import jorn.hiel.urentracker.views.main.MainView;
import com.vaadin.flow.component.dependency.CssImport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Route(value = "urenConfig", layout = MainView.class)
@PageTitle("uren config")
@CssImport("./views/urenconfig/urenconfig-view.css")
public class UrenconfigView extends HorizontalLayout {

    private TextField name;

    final private TextField maandagTextField, dinsdagTextField, woensdagTextField, donderdagTextField, vrijdagTextField, zaterdagTextField, zondagTextField;


    private Button sayHello;
    private Button update;

    public UrenconfigView() {
        addClassName("urenconfig-view");
        FormLayout layoutWithFormItems = new FormLayout();


        maandagTextField =new TextField();
        dinsdagTextField =new TextField();
        woensdagTextField =new TextField();
        donderdagTextField =new TextField();
        vrijdagTextField =new TextField();
        zaterdagTextField =new TextField();
        zondagTextField =new TextField();

        List<TextField> fields = Arrays.asList(maandagTextField,dinsdagTextField,woensdagTextField,donderdagTextField,vrijdagTextField,zaterdagTextField,zondagTextField);

        fields.forEach(a-> setCommon(a));



        update = new Button("Update");

        layoutWithFormItems.addFormItem(maandagTextField,"Maandag");
        layoutWithFormItems.addFormItem(vrijdagTextField,"Vrijdag");
        layoutWithFormItems.addFormItem(dinsdagTextField,"Dinsdag");
        layoutWithFormItems.addFormItem(zaterdagTextField,"Zaterdag");
        layoutWithFormItems.addFormItem(woensdagTextField,"Woensdag");
        layoutWithFormItems.addFormItem(zondagTextField,"Zondag");
        layoutWithFormItems.addFormItem(donderdagTextField,"Donderdag");


        add(layoutWithFormItems);
        add(update);




        update.addClickListener(e -> {
            Notification.show("pushed update");
        });
    }

    private void setCommon(TextField field) {
        field.setPlaceholder("00:00");
        field.setRequired(true);
    }


}
