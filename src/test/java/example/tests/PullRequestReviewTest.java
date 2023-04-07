package example.tests;

import org.example.Appender;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
import org.example.yy.PullRequestReview;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PullRequestReviewTest {
	@Test
	public void test() {
		PullRequestReview pullRequestReview = PullRequestReview.$();
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequestReview.accept(visitor, appender);
		String expected = "pull_request_review:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testTypes() {
		PullRequestReview pullRequestComment = PullRequestReview.$()
				.types(PullRequestReview.Type.values());
		
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequestComment.accept(visitor, appender);
		String expected = "pull_request_review:\n" +
				"  types:\n" +
				"    - dismissed\n" +
				"    - edited\n" +
				"    - submitted";
		Assertions.assertEquals(expected, appender.toString());
	}
}
