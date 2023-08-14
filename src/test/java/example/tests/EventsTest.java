package example.tests;

import org.example.collections.Events;
import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.example.yy.PullRequest;
import org.example.yy.PullRequestTarget;
import org.example.yy.Push;
import org.example.yy.WorkflowDispatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EventsTest {
    @Test
    public void test() {
        Events events = new Events();
        events.add(Push.$());
        events.add(PullRequestTarget.$());
        events.add(WorkflowDispatch.$());
        events.add(PullRequest.$());

        Visitor<String> visitor = new StringPrinterVisitor();
        events.accept(visitor);
        String expected = "on:\n" +
                "  push:\n" +
                "  pull_request_target:\n" +
                "  workflow_dispatch:\n" +
                "  pull_request:";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}
