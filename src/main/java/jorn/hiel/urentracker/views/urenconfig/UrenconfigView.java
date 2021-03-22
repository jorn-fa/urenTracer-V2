package jorn.hiel.urentracker.views.urenconfig;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import jorn.hiel.urentracker.views.main.MainView;
import com.vaadin.flow.component.dependency.CssImport;

@Route(value = "urenConfig", layout = MainView.class)
@PageTitle("uren config")
@CssImport("./views/urenconfig/urenconfig-view.css")
public class UrenconfigView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public UrenconfigView() {
        addClassName("urenconfig-view");
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        add(name, sayHello);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
    }

}
