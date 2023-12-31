package example.tests;

import org.example.yy.BranchProtectionRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BranchProtectionRuleTest extends AbstracTest {

    @Test
    public void initTest() {
        BranchProtectionRule release = BranchProtectionRule.$();
        release.accept(visitor);
        String expected = "branch_protection_rule:";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testTypes() {
        BranchProtectionRule release = BranchProtectionRule.$()
                .types(BranchProtectionRule.Type.CREATED)
                .types(BranchProtectionRule.Type.DELETED)
                .types(BranchProtectionRule.Type.EDITED);
        release.accept(visitor);
        String expected = "branch_protection_rule:\n" +
                "  types:\n" +
                "    - created\n" +
                "    - deleted\n" +
                "    - edited";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}
