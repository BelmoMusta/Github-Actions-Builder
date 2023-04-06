package example.tests;

import org.example.yy.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatusTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Status status = Status.$();
		status.accept(visitor, appender);
		String expected = "status:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
}
