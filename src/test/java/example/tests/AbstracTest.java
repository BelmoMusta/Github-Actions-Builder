package example.tests;

import org.example.Appender;
import org.example.Release;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstracTest {
	protected Appender appender;
	protected Visitor<Appender> visitor;
	
	@BeforeEach
	public void before() {
		appender = new Appender();
		visitor = new DefaultVisitorImpl();
	}
}
