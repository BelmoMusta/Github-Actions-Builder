package example.tests;

import org.example.Discussion;
import org.example.Release;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscussionTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Discussion discussion = Discussion.$();
		discussion.accept(visitor, appender);
		String expected = "discussion:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void releaseTypesTest() {
		Discussion discussion = Discussion.$()
				.types(Discussion.Type.UNLOCKED)
				.types(Discussion.Type.ANSWERED)
				.types(Discussion.Type.CATEGORY_CHANGED)
				.types(Discussion.Type.CREATED)
				.types(Discussion.Type.DELETED)
				.types(Discussion.Type.EDITED)
				.types(Discussion.Type.LABELED)
				.types(Discussion.Type.LOCKED)
				.types(Discussion.Type.PINNED)
				.types(Discussion.Type.TRANSFERRED)
				.types(Discussion.Type.UNANSWERED)
				.types(Discussion.Type.UNLABELED)
				.types(Discussion.Type.UNPINNED)
				
				;
		discussion.accept(visitor, appender);
		String expected = "discussion:\n" +
				"  types:\n" +
				"    - unlocked\n" +
				"    - answered\n" +
				"    - category_changed\n" +
				"    - created\n" +
				"    - deleted\n" +
				"    - edited\n" +
				"    - labeled\n" +
				"    - locked\n" +
				"    - pinned\n" +
				"    - transferred\n" +
				"    - unanswered\n" +
				"    - unlabeled\n" +
				"    - unpinned";
		Assertions.assertEquals(expected, appender.toString());
	}
}
