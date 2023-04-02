package example.tests;

import org.example.Appender;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstracTest {
	protected Appender appender;
	protected Visitor<Appender> visitor;
	
	@BeforeEach
	public void before() {
		appender = new Appender();
		visitor = new DefaultVisitorImpl();
	}
}
