package example.tests;

import org.example.Release;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReleaseTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Release release = Release.$();
		release.accept(visitor, appender);
		String expected = "release:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void releaseTypesTest() {
		Release release = Release.$()
				.types(Release.Type.RELEASED)
				.types(Release.Type.CREATED);
		release.accept(visitor, appender);
		String expected = "release:\n" +
				"  types:\n" +
				"    - released\n"+
				"    - created";
		Assertions.assertEquals(expected, appender.toString());
	}
}
