package example.tests;

import org.example.yy.Create;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateTest extends AbstracTest {

    @Test
    public void initTest() {
        Create create = Create.$();
        create.accept(visitor);
        String expected = "create:";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}
