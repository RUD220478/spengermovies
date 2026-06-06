package at.spengergasse.views.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin.Minus.Horizontal;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Home")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.HOME_SOLID)
public class HomeView extends VerticalLayout {

    public HomeView() {
        setSpacing(false);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        // Call Header, this is HomeView.getHeader() intentionally!
        add(HomeView.getHeader());

        // Image: Logo
        Image img = new Image("images/movies_logo.png", "placeholder plant");
        img.setWidth("220px");
        img.setHeight("150px");
        
        Paragraph description = new Paragraph(
                "In unseren Establishments verbinden wir Kino mit heimeliger Atmospähre " +
                "Feiern Sie mit Freunden, Familie oder mit Leuten aus der Arbeit – " +
                "Von knallharten Actionthrillern bis zärtlichen Liebesverfilmungen haben wir alles " +
                "Wir freuen uns auf Ihre Anfrage! - Ihr Spengermovies Team"
        );

        HorizontalLayout desc = new HorizontalLayout(img, description);
        add(desc);

        description.setWidth("500px");
        description.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");

        H3 name = new H3("Spengerfilmvorführgesellschaft GmbH");
        H3 street = new H3("Spengergasse 20");
        H3 city = new H3("1050 Wien");

        HorizontalLayout address = new HorizontalLayout(name, street, city);
        address.getStyle().set("gap", "40px");
        add(address);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    // Header, add via: add(HomeView.getHeader());
    public static Component getHeader(){

        H1 companyName = new H1("SPENGERMOVIES");
        companyName.getStyle()
        .set("font-family", "cursive")
        .set("font-size", "2rem")
        .set("margin", "0");

        H2 subName = new H2("Filmgenuss für Filmfans");
        subName.getStyle()
        .set("margin", "0")
        .set("color", "gray");

        VerticalLayout headerLayout = new VerticalLayout(companyName, subName);
        headerLayout.setSpacing(false);
        headerLayout.setPadding(false);
        headerLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        return headerLayout;
    }
}
