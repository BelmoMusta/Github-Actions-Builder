package example.tests;

import org.example.yy.DiscussionComment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscussionCommentTest extends AbstracTest {
	
	@Test
	public void initTest() {
		DiscussionComment discussionComment = DiscussionComment.$();
		discussionComment.accept(visitor, appender);
		String expected = "discussion_comment:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testTypes() {
		DiscussionComment discussionComment = DiscussionComment.$()
				.types(DiscussionComment.Type.CREATED)
				.types(DiscussionComment.Type.DELETED)
				.types(DiscussionComment.Type.EDITED);
		discussionComment.accept(visitor, appender);
		String expected = "discussion_comment:\n" +
				"  types:\n" +
				"    - created\n" +
				"    - deleted\n" +
				"    - edited";
		Assertions.assertEquals(expected, appender.toString());
	}
}
