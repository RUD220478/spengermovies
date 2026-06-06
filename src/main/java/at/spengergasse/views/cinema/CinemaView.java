package at.spengergasse.views.cinema;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Flex;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin.Minus.Vertical;

import at.spengergasse.views.home.HomeView;

import java.util.OptionalDouble;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Cinema")
@Route("Cinema")
@Menu(order = 2, icon = LineAwesomeIconUrl.FILM_SOLID)
public class CinemaView extends VerticalLayout {

    public CinemaView() {
        
        setSpacing(false);
        add(HomeView.getHeader());

        H2 title = new H2("Kinos");
        add(title);

        Component card0 = getCard("Mariahilf", 10.50, OptionalDouble.of(20.00));
        Component card1 = getCard("Donaustadt", 8.90, OptionalDouble.of(14.00));
        Component card2 = getCard("Floridsdorf", 6.50, OptionalDouble.of(12.00));
        Component card3 = getCard("Favoriten", 0.00, OptionalDouble.empty());
        Component card4 = getCard("Döbling", 23.00, OptionalDouble.empty());

        FlexLayout cards = new FlexLayout(card0, card1, card2, card3, card4);
        cards.setWidthFull();
        cards.setJustifyContentMode(JustifyContentMode.CENTER);
        cards.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        add(cards);

        Paragraph info = new Paragraph("Wir freuen uns auf Ihren Besuch!");
        info.setWidth("100%");
        info.getStyle().set("text-align", "center");
        add(info);
    }

    private Component getCard(String theatreName, double ticketPrice, OptionalDouble popcornFree){
        Paragraph free;

        H2 theatre = new H2(theatreName);
        Paragraph price = new Paragraph(ticketPrice + " Euro");
        if (popcornFree.isPresent()){
                free = new Paragraph("Gratis Popcorn bei Bestellung Gesamtbetrag über " + popcornFree.getAsDouble() + " Euro.");
        } else {
                free = new Paragraph("Kein Gratis Popcorn.");
        }
        VerticalLayout card = new VerticalLayout(theatre, price, free);
        card.setWidth("350px");
        card.setPadding(true);
        card.setSpacing(false);

        card.getStyle()
                .set("border", "1px solid lightgray")
                .set("border-radius", "10px")
                .set("margin", "10px");
        return card;
    }

}
