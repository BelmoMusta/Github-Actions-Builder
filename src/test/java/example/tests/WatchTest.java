package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.example.yy.Watch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WatchTest {
	@Test
	public void test() {
		Watch watch = Watch.$();
		
		Visitor<String> visitor = new StringPrinterVisitor();
		watch.accept(visitor);
		String expected = "watch:";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testTypes() {
		Watch watch = Watch.$()
				.types(Watch.Type.values());
		
		
		Visitor<String> visitor = new StringPrinterVisitor();
		watch.accept(visitor);
		String expected = "watch:\n" +
				"  types:\n" +
				"    - started";
		Assertions.assertEquals(expected, visitor.getResult());
	}
}
