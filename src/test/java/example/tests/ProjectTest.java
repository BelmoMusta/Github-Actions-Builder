package example.tests;

import org.example.yy.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjectTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Project project = Project.$();
		project.accept(visitor, appender);
		String expected = "project:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void releaseTypesTest() {
		Project project = Project.$()
				.types(Project.Type.values());
		project.accept(visitor, appender);
		String expected = "project:\n" +
				"  types:\n" +
				"    - closed\n" +
				"    - created\n" +
				"    - deleted\n" +
				"    - edited\n" +
				"    - reopened";
		Assertions.assertEquals(expected, appender.toString());
	}
}
