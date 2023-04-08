package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.example.yy.PullRequestReviewComment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PullRequestReviewCommentTest {
	@Test
	public void test() {
		PullRequestReviewComment pullRequestReviewComment = PullRequestReviewComment.$();
		
		Visitor<String> visitor = new StringPrinterVisitor();
		pullRequestReviewComment.accept(visitor);
		String expected = "pull_request_review_comment:";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testTypes() {
		PullRequestReviewComment pullRequestComment = PullRequestReviewComment.$()
				.types(PullRequestReviewComment.Type.values());
		
		
		Visitor<String> visitor = new StringPrinterVisitor();
		pullRequestComment.accept(visitor);
		String expected = "pull_request_review_comment:\n" +
				"  types:\n" +
				"    - created\n" +
				"    - deleted\n" +
				"    - edited";
		Assertions.assertEquals(expected, visitor.getResult());
	}
}
