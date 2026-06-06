package at.spengergasse.views.home;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Home")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.HOME_SOLID)
public class HomeView extends VerticalLayout {

    public HomeView() {
        setSpacing(false);

        H1 companyName = new H1("SPENGERMOVIES");
        companyName.getStyle()
                .set("font-family", "cursive")
                .set("font-size", "2rem")
                .set("margin", "0");

        Image img = new Image("images/movies_logo.png", "placeholder plant");
        img.setWidth("30%");
        add(img);

        H2 subName = new H2("Filmgenuss unter Verschluss");
        subName.getStyle()
                .set("margin", "0")
                .set("color", "gray");

        Paragraph description = new Paragraph(
                "In unserem Establishment verbinden wir Kino mit heimeliger Privatsphäre " +
                "Feiern Sie mit Freunden, Familie oder mit Leuten aus der Arbeit – " +
                "Von knallharten Actionthrillern bis zärtlichen Liebesverfilmungen haben wir alles " +
                "Wir freuen uns auf Ihre Anfrage! - Ihr Spengermovies Team"
        );

        description.setWidth("500px");
        description.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");

        H3 name = new H3("Spengerfilmvorführgesellschaft GmbH");
        H3 street = new H3("Spengergasse 20");
        H3 city = new H3("1050 Wien");

        add(companyName, img, subName, description, name, street, city);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
