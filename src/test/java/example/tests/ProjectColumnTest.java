package example.tests;

import org.example.yy.ProjectColumn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjectColumnTest extends AbstracTest {
	
	@Test
	public void initTest() {
		ProjectColumn projectColumn = ProjectColumn.$();
		projectColumn.accept(visitor);
		String expected = "project_column:";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void releaseTypesTest() {
		ProjectColumn projectCard = ProjectColumn.$()
				.types(ProjectColumn.Type.values());
		projectCard.accept(visitor);
		String expected = "project_column:\n" +
				"  types:\n" +
				"    - created\n" +
				"    - deleted\n" +
				"    - moved\n" +
				"    - updated";
		Assertions.assertEquals(expected, visitor.getResult());
	}
}
