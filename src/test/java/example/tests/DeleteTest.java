package example.tests;

import org.example.yy.Delete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Delete delete = Delete.$();
		delete.accept(visitor);
		String expected = "delete:";
		Assertions.assertEquals(expected, visitor.getResult());
	}
}
