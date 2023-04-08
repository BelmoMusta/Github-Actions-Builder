package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.example.yy.PullRequestReview;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PullRequestReviewTest {
	@Test
	public void test() {
		PullRequestReview pullRequestReview = PullRequestReview.$();
		
		Visitor<String> visitor = new StringPrinterVisitor();
		pullRequestReview.accept(visitor);
		String expected = "pull_request_review:";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testTypes() {
		PullRequestReview pullRequestComment = PullRequestReview.$()
				.types(PullRequestReview.Type.values());
		
		
		Visitor<String> visitor = new StringPrinterVisitor();
		pullRequestComment.accept(visitor);
		String expected = "pull_request_review:\n" +
				"  types:\n" +
				"    - dismissed\n" +
				"    - edited\n" +
				"    - submitted";
		Assertions.assertEquals(expected, visitor.getResult());
	}
}
