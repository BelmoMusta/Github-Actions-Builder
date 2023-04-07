package example.tests;

import org.example.Appender;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
import org.example.yy.PullRequestReviewComment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PullRequestReviewCommentTest {
	@Test
	public void test() {
		PullRequestReviewComment pullRequestReviewComment = PullRequestReviewComment.$();
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequestReviewComment.accept(visitor, appender);
		String expected = "pull_request_review_comment:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testTypes() {
		PullRequestReviewComment pullRequestComment = PullRequestReviewComment.$()
				.types(PullRequestReviewComment.Type.values());
		
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequestComment.accept(visitor, appender);
		String expected = "pull_request_review_comment:\n" +
				"  types:\n" +
				"    - created\n" +
				"    - deleted\n" +
				"    - edited";
		Assertions.assertEquals(expected, appender.toString());
	}
}
