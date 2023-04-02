package example.tests;

import org.example.CheckRun;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckRunTest extends AbstracTest {
 
	
	@Test
	public void initTest() {
		CheckRun checkRun = CheckRun.$();
		checkRun.accept(visitor, appender);
		String expected = "check_run:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void checkRunTest() {
		CheckRun release = CheckRun.$()
				.types(CheckRun.Type.COMPLETED)
				.types(CheckRun.Type.CREATED)
				.types(CheckRun.Type.REQUESTED_ACTION)
				.types(CheckRun.Type.REREQUESTED)
				;
		release.accept(visitor, appender);
		String expected = "check_run:\n" +
				"  types:\n" +
				"    - completed\n" +
				"    - created\n" +
				"    - requested_action\n" +
				"    - rerequested";
		Assertions.assertEquals(expected, appender.toString());
	}
}
