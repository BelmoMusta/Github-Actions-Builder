package example.tests;

import org.example.yy.CheckSuite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckSuiteTest extends AbstracTest {

    @Test
    public void initTest() {
        CheckSuite checkSuite = CheckSuite.$();
        checkSuite.accept(visitor);
        String expected = "check_suite:";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void releaseTypesTest() {
        CheckSuite release = CheckSuite.$()
                .types(CheckSuite.Type.COMPLETED);
        release.accept(visitor);
        String expected = "check_suite:\n" +
                "  types:\n" +
                "    - completed";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}
