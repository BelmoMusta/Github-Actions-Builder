package example.tests;

import org.example.wrappers.UnknownTag;
import org.junit.jupiter.api.Test;

public class UnkownTagTest extends AbstracTest {
	
	@Test
	public void initTest() {
		UnknownTag unknownTag = new UnknownTag();
		unknownTag.accept(visitor);
		//String expected = "page_build:";
		//Assertions.assertEquals(expected, visitor.getResult());
	}
	
}
