package example.tests;

import org.example.yy.MergeGroup;
import org.example.yy.Milestone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MileStoneTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Milestone milestone = Milestone.$();
		milestone.accept(visitor, appender);
		String expected = "milestone:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void releaseTypesTest() {
		Milestone release = Milestone.$()
				.types(Milestone.Type.values());
		release.accept(visitor, appender);
		String expected = "milestone:\n" +
				"  types:\n" +
				"    - closed\n" +
				"    - created\n" +
				"    - deleted\n" +
				"    - edited\n" +
				"    - opened";
		Assertions.assertEquals(expected, appender.toString());
	}
}
