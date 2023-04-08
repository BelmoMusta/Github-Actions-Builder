package example.tests;

import org.example.yy.Release;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReleaseTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Release release = Release.$();
		release.accept(visitor);
		String expected = "release:";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void releaseTypesTest() {
		Release release = Release.$()
				.types(Release.Type.RELEASED)
				.types(Release.Type.CREATED);
		release.accept(visitor);
		String expected = "release:\n" +
				"  types:\n" +
				"    - released\n" +
				"    - created";
		Assertions.assertEquals(expected, visitor.getResult());
	}
}
