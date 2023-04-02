package example.tests;

import org.example.yy.CheckSuite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckSuiteTest extends AbstracTest {
	
	@Test
	public void initTest() {
		CheckSuite checkSuite = CheckSuite.$();
		checkSuite.accept(visitor, appender);
		String expected = "check_suite:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void releaseTypesTest() {
		CheckSuite release = CheckSuite.$()
				.types(CheckSuite.Type.COMPLETED);
		release.accept(visitor, appender);
		String expected = "check_suite:\n" +
				"  types:\n" +
				"    - completed";
		Assertions.assertEquals(expected, appender.toString());
	}
}
