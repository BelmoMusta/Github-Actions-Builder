package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.example.yy.PullRequestTarget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PullRequestTargetTest {
    @Test
    public void test() {
        PullRequestTarget pullRequestTarget = PullRequestTarget.$();

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequestTarget.accept(visitor);
        String expected = "pull_request_target:";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testTypes() {
        PullRequestTarget pullRequestTarget = PullRequestTarget.$()
                .types(PullRequestTarget.Type.values());

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequestTarget.accept(visitor);
        String expected = "pull_request_target:\n" +
                "  types:\n" +
                "    - assigned\n" +
                "    - auto_merge_disabled\n" +
                "    - auto_merge_enabled\n" +
                "    - closed\n" +
                "    - converted_to_draft\n" +
                "    - edited\n" +
                "    - labeled\n" +
                "    - locked\n" +
                "    - opened\n" +
                "    - ready_for_review\n" +
                "    - reopened\n" +
                "    - review_request_removed\n" +
                "    - review_requested\n" +
                "    - synchronize\n" +
                "    - unassigned\n" +
                "    - unlabeled\n" +
                "    - unlocked";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testBranches() {
        PullRequestTarget pullRequestTarget = PullRequestTarget.$()
                .branches("a", "b")
                .branchesIgnore("c", "d");

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequestTarget.accept(visitor);
        String expected = "pull_request_target:\n" +
                "  branches:\n" +
                "    - 'a'\n" +
                "    - 'b'\n" +
                "  branches-ignore:\n" +
                "    - 'c'\n" +
                "    - 'd'";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testBranchesIgnore() {
        PullRequestTarget pullRequestTarget = PullRequestTarget.$()
                .branchesIgnore("c", "d");

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequestTarget.accept(visitor);
        String expected = "pull_request_target:\n" +
                "  branches-ignore:\n" +
                "    - 'c'\n" +
                "    - 'd'";
        Assertions.assertEquals(expected, visitor.getResult());
    }


    @Test
    public void testPaths() {
        PullRequestTarget pullRequestTarget = PullRequestTarget.$()
                .paths("a/n", "b/c");

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequestTarget.accept(visitor);
        String expected = "pull_request_target:\n" +
                "  paths:\n" +
                "    - 'a/n'\n" +
                "    - 'b/c'";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testPathsIgnore() {
        PullRequestTarget pullRequestTarget = PullRequestTarget.$()
                .pathsIgnore("e/m")
                .pathsIgnore("f/j");

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequestTarget.accept(visitor);
        String expected = "pull_request_target:\n" +
                "  paths-ignore:\n" +
                "    - 'e/m'\n" +
                "    - 'f/j'";
        Assertions.assertEquals(expected, visitor.getResult());

    }

}
