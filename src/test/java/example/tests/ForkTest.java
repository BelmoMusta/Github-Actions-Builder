package example.tests;

import org.example.yy.Fork;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ForkTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Fork fork = Fork.$();
		fork.accept(visitor, appender);
		String expected = "fork:";
		Assertions.assertEquals(expected, appender.toString());
	}
}
