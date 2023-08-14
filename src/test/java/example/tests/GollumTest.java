package example.tests;

import org.example.yy.Gollum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GollumTest extends AbstracTest {

    @Test
    public void initTest() {
        Gollum gollum = Gollum.$();
        gollum.accept(visitor);
        String expected = "gollum:";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}
