package at.spengergasse.domain;

//import org.junit.jupiter.api.Test;
import java.time.LocalDate;
//import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    //@Test
    public void testToString() {
        Order a = new Order(LocalDate.now(),"Matrix","Back",3,9.5,true);
        System.out.println(a);
    }

}
