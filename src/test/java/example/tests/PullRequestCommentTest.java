package example.tests;

import org.example.Appender;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
import org.example.yy.PullRequestComment;
import org.example.yy.PullRequestTarget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PullRequestCommentTest {
	@Test
	public void test() {
		PullRequestComment pullRequestComment = PullRequestComment.$();
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequestComment.accept(visitor, appender);
		String expected = "pull_request_comment:";
		Assertions.assertEquals(expected, appender.toString());
	}
}
