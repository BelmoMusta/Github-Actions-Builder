package example.tests;

import org.example.yy.BranchProtectionRule;
import org.example.yy.IssueComment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IssueCommentTest extends AbstracTest {
	
	@Test
	public void initTest() {
		IssueComment issueComment = IssueComment.$();
		issueComment.accept(visitor, appender);
		String expected = "issue_comment:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testTypes() {
		IssueComment release = IssueComment.$()
				.types(IssueComment.Type.CREATED)
				.types(IssueComment.Type.DELETED)
				.types(IssueComment.Type.EDITED);
		release.accept(visitor, appender);
		String expected = "issue_comment:\n" +
				"  types:\n" +
				"    - created\n" +
				"    - deleted\n" +
				"    - edited";
		Assertions.assertEquals(expected, appender.toString());
	}
}
