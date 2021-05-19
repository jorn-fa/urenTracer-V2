package jorn.hiel.urentracker.views.urenconfig;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import jorn.hiel.urentracker.controllers.ConfigUrenPresenter;
import jorn.hiel.urentracker.service.managers.WorkhourManager;
import jorn.hiel.urentracker.views.main.MainView;
import com.vaadin.flow.component.dependency.CssImport;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Route(value = "urenConfig", layout = MainView.class)
@PageTitle("uren config")
@CssImport("./views/urenconfig/urenconfig-view.css")
@SpringComponent
@UIScope

public class UrenconfigView extends HorizontalLayout {

    @Autowired
    ConfigUrenPresenter presenter;

    @Autowired
    WorkhourManager manager;

    @Getter
    final private TextField maandagTextField, dinsdagTextField, woensdagTextField, donderdagTextField, vrijdagTextField, zaterdagTextField, zondagTextField;

    @Getter
    private Button updateButton;

    @Getter
    List<TextField>fields;

    @PostConstruct
    public void init(){
        presenter.setView(this);
        presenter.init();
    }

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

        fields = Arrays.asList(maandagTextField,dinsdagTextField,woensdagTextField,donderdagTextField,vrijdagTextField,zaterdagTextField,zondagTextField);

        fields.forEach(this::setCommon);



        updateButton = new Button("Update");



        layoutWithFormItems.addFormItem(maandagTextField,"Maandag");
        layoutWithFormItems.addFormItem(vrijdagTextField,"Vrijdag");
        layoutWithFormItems.addFormItem(dinsdagTextField,"Dinsdag");
        layoutWithFormItems.addFormItem(zaterdagTextField,"Zaterdag");
        layoutWithFormItems.addFormItem(woensdagTextField,"Woensdag");
        layoutWithFormItems.addFormItem(zondagTextField,"Zondag");
        layoutWithFormItems.addFormItem(donderdagTextField,"Donderdag");

        add(layoutWithFormItems);
        add(updateButton);



    }



    /**
     * helper method to set common parameters
     * @param field Textield field
     */
    private void setCommon(TextField field) {
        field.setPlaceholder("00:00");
        field.setRequired(true);
        field.setMaxLength(5);
        field.setMinLength(5);
        field.setHelperText("maximum uren in formaat xx:yy");
        field.setPattern();
    }


}
