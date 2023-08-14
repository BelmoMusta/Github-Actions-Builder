package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.example.yy.PullRequestComment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PullRequestCommentTest {
    @Test
    public void test() {
        PullRequestComment pullRequestComment = PullRequestComment.$();

        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequestComment.accept(visitor);
        String expected = "pull_request_comment:";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testTypes() {
        PullRequestComment pullRequestComment = PullRequestComment.$()
                .types(PullRequestComment.Type.values());


        Visitor<String> visitor = new StringPrinterVisitor();
        pullRequestComment.accept(visitor);
        String expected = "pull_request_comment:\n" +
                "  types:\n" +
                "    - created\n" +
                "    - deleted\n" +
                "    - edited";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}
