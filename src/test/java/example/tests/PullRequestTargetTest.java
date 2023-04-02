package example.tests;

import org.example.Appender;
import org.example.yy.PullRequestTarget;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PullRequestTargetTest {
	@Test
	public void test() {
		PullRequestTarget pullRequestTarget = PullRequestTarget.$();
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequestTarget.accept(visitor, appender);
		String expected = "pull_request_target:";
		Assertions.assertEquals(expected, appender.toString());
	}
}
