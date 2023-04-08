package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.example.yy.RepositoryDispatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryDispatchTest {
	@Test
	public void test() {
		RepositoryDispatch repositoryDispatch = RepositoryDispatch.$();
		
		Visitor<String> visitor = new StringPrinterVisitor();
		repositoryDispatch.accept(visitor);
		String expected = "repository_dispatch:";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testTypes() {
		RepositoryDispatch pullRequestComment = RepositoryDispatch.$()
				.types("test-wf")
				.types("test-wf-2");
		
		
		Visitor<String> visitor = new StringPrinterVisitor();
		pullRequestComment.accept(visitor);
		String expected = "repository_dispatch:\n" +
				"  types:\n" +
				"    - test-wf\n" +
				"    - test-wf-2";
		Assertions.assertEquals(expected, visitor.getResult());
	}
}
