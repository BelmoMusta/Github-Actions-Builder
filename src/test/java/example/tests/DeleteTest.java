package example.tests;

import org.example.Create;
import org.example.Delete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Delete delete = Delete.$();
		delete.accept(visitor, appender);
		String expected = "delete:";
		Assertions.assertEquals(expected, appender.toString());
	}
}