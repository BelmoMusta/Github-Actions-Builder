package example.tests;

import org.example.Appender;
import org.example.yy.PullRequest;
import org.example.yy.PullRequestTarget;
import org.example.yy.Push;
import org.example.yy.WorkflowDispatch;
import org.example.collections.Events;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
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
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		events.accept(visitor, appender);
		String expected = "on:\n" +
				"  push:\n" +
				"  pull_request_target:\n"+
				"  workflow_dispatch:\n"+
				"  pull_request:";
		Assertions.assertEquals(expected, appender.toString());
	}
}
