package example.tests;

import org.example.yy.Public;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PublicTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Public aPublic = Public.$();
		aPublic.accept(visitor, appender);
		String expected = "public:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
}
