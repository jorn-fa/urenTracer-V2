package jorn.hiel.urentracker.views.yearoverview;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import jorn.hiel.urentracker.views.main.MainView;
import com.vaadin.flow.component.dependency.CssImport;

@Route(value = "yearoverview", layout = MainView.class)
@PageTitle("YearOverview")
@CssImport("./views/yearoverview/year-overview-view.css")
public class YearOverviewView extends Div {

    public YearOverviewView() {
        addClassName("year-overview-view");
        add(new Text("Content placeholder"));
    }

}
