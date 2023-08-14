package example.tests;

import org.example.yy.Issues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IssuesTest extends AbstracTest {

    @Test
    public void initTest() {
        Issues issues = Issues.$();
        issues.accept(visitor);
        String expected = "issues:";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testTypes() {
        Issues issues = Issues.$()
                .types(Issues.Type.values());

        issues.accept(visitor);
        String expected = "issues:\n" +
                "  types:\n" +
                "    - assigned\n" +
                "    - closed\n" +
                "    - deleted\n" +
                "    - demilestoned\n" +
                "    - edited\n" +
                "    - labeled\n" +
                "    - locked\n" +
                "    - milestoned\n" +
                "    - opened\n" +
                "    - pinned\n" +
                "    - reopened\n" +
                "    - transferred\n" +
                "    - unassigned\n" +
                "    - unlabeled\n" +
                "    - unlocked\n" +
                "    - unpinned";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}
