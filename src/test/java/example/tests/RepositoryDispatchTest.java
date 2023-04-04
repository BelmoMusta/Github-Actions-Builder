package example.tests;

import org.example.Appender;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
import org.example.yy.PullRequestComment;
import org.example.yy.RepositoryDispatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryDispatchTest {
	@Test
	public void test() {
		RepositoryDispatch repositoryDispatch = RepositoryDispatch.$();
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		repositoryDispatch.accept(visitor, appender);
		String expected = "repository_dispatch:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testTypes() {
		RepositoryDispatch pullRequestComment = RepositoryDispatch.$()
				.types("test-wf")
				.types("test-wf-2");
		
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequestComment.accept(visitor, appender);
		String expected = "repository_dispatch:\n" +
				"  types:\n" +
				"    - test-wf\n"+
				"    - test-wf-2";
		Assertions.assertEquals(expected, appender.toString());
	}
}
