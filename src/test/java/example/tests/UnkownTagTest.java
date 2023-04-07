package example.tests;

import org.example.wrappers.UnknownTag;
import org.junit.jupiter.api.Test;

public class UnkownTagTest extends AbstracTest {
	
	@Test
	public void initTest() {
		UnknownTag unknownTag = new UnknownTag();
		unknownTag.accept(visitor, appender);
		//String expected = "page_build:";
		//Assertions.assertEquals(expected, appender.toString());
	}
	
}
