package example.tests;

import org.example.yy.PullRequestTarget;
import org.example.visitor.DefaultVoidVisitorImpl;
import org.example.visitor.VoidVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VoidVistorTest {
	@Test
	public void test() {
		PullRequestTarget pullRequestTarget = PullRequestTarget.$();
		
		VoidVisitor<String> visitor = new DefaultVoidVisitorImpl();
		pullRequestTarget.accept(visitor);
		String expected = "pull_request_target:";
		Assertions.assertEquals(expected, visitor.getFinalResult());
	}
}
