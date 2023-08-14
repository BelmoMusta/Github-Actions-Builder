package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.example.yy.PullRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PullRequestTest {
    @Test
    public void testInit() {
        PullRequest pullRequest = PullRequest.$();

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequest.accept(visitor);
        String expected = "pull_request:";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testTypes() {
        PullRequest pullRequest = PullRequest.$()
                .types(PullRequest.Type.values());

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequest.accept(visitor);
        String expected = "pull_request:\n" +
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
                "    - review_requested\n" +
                "    - review_request_removed\n" +
                "    - synchronize\n" +
                "    - unassigned\n" +
                "    - unlabeled\n" +
                "    - unlocked";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testBranches() {
        PullRequest pullRequest = PullRequest.$()
                .branches("a", "b")
                .branchesIgnore("c", "d");

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequest.accept(visitor);
        String expected = "pull_request:\n" +
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
        PullRequest pullRequest = PullRequest.$()
                .branchesIgnore("c", "d");

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequest.accept(visitor);
        String expected = "pull_request:\n" +
                "  branches-ignore:\n" +
                "    - 'c'\n" +
                "    - 'd'";
        Assertions.assertEquals(expected, visitor.getResult());
    }


    @Test
    public void testPaths() {
        PullRequest pullRequest = PullRequest.$()
                .paths("a/n", "b/c");

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequest.accept(visitor);
        String expected = "pull_request:\n" +
                "  paths:\n" +
                "    - 'a/n'\n" +
                "    - 'b/c'";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testPathsIgnore() {
        PullRequest pullRequest = PullRequest.$()
                .pathsIgnore("e/m")
                .pathsIgnore("f/j");

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequest.accept(visitor);
        String expected = "pull_request:\n" +
                "  paths-ignore:\n" +
                "    - 'e/m'\n" +
                "    - 'f/j'";
        Assertions.assertEquals(expected, visitor.getResult());

    }
}
