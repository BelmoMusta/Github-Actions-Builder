package example.tests;

import org.example.Appender;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
import org.example.yy.RegistryPackage;
import org.example.yy.Watch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WatchTest {
	@Test
	public void test() {
		Watch watch = Watch.$();
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		watch.accept(visitor, appender);
		String expected = "watch:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testTypes() {
		Watch watch = Watch.$()
				.types(Watch.Type.values());
		
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		watch.accept(visitor, appender);
		String expected = "watch:\n" +
				"  types:\n" +
				"    - started";
		Assertions.assertEquals(expected, appender.toString());
	}
}
