package at.spengergasse.views.show;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import at.spengergasse.views.home.HomeView;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Show")
@Route("show")
@Menu(order = 2, icon = LineAwesomeIconUrl.FILM_SOLID)
public class ShowView extends VerticalLayout {

    public ShowView() {
        
        setSpacing(false);
        add(HomeView.getHeader());

        H2 title = new H2("Vorführungen");

        H2 movie1 = new H2("Avengers");
        Paragraph price1 = new Paragraph("Pro Person: 10,00 Euro");
        Paragraph private1 = new Paragraph("Privatvorstellung ab 200 Euro");
        Paragraph gruppe1 = new Paragraph("Gruppenermäßigung 25 % ab 10 Personen");

        H2 movie2 = new H2("Batman");
        Paragraph price2 = new Paragraph("Pro Person: 8,00 Euro");
        Paragraph private2 = new Paragraph("Privatvorstellung ab 160 Euro");
        Paragraph gruppe2 = new Paragraph("Gruppenermäßigung 30 % ab 20 Personen");

        H2 movie3 = new H2("Matrix");
        Paragraph price3 = new Paragraph("Pro Person: 6,50 Euro");
        Paragraph private3 = new Paragraph("Privatvorstellung ab 120 Euro");
        Paragraph gruppe3 = new Paragraph("Gruppenermäßigung 10 % ab 30 Personen");

        add(
                title,
                movie1, price1, private1, gruppe1,
                movie2, price2, private2, gruppe2,
                movie3, price3, private3, gruppe3

        );
    }

}
