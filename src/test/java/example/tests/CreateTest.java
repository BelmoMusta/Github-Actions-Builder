package example.tests;

import org.example.Create;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Create create = Create.$();
		create.accept(visitor, appender);
		String expected = "create:";
		Assertions.assertEquals(expected, appender.toString());
	}
}
