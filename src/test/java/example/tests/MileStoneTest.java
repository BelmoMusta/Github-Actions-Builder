package example.tests;

import org.example.yy.Milestone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MileStoneTest extends AbstracTest {

    @Test
    public void initTest() {
        Milestone milestone = Milestone.$();
        milestone.accept(visitor);
        String expected = "milestone:";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void releaseTypesTest() {
        Milestone release = Milestone.$()
                .types(Milestone.Type.values());
        release.accept(visitor);
        String expected = "milestone:\n" +
                "  types:\n" +
                "    - closed\n" +
                "    - created\n" +
                "    - deleted\n" +
                "    - edited\n" +
                "    - opened";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}
