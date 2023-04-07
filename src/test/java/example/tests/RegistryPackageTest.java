package example.tests;

import org.example.Appender;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
import org.example.yy.RegistryPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistryPackageTest {
	@Test
	public void test() {
		RegistryPackage registryPackage = RegistryPackage.$();
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		registryPackage.accept(visitor, appender);
		String expected = "registry_package:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testTypes() {
		RegistryPackage registryPackage = RegistryPackage.$()
				.types(RegistryPackage.Type.values());
		
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		registryPackage.accept(visitor, appender);
		String expected = "registry_package:\n" +
				"  types:\n" +
				"    - published\n" +
				"    - updated";
		Assertions.assertEquals(expected, appender.toString());
	}
}
