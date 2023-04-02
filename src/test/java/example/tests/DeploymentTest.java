package example.tests;

import org.example.yy.Deployment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeploymentTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Deployment deployment = Deployment.$();
		deployment.accept(visitor, appender);
		String expected = "deployment:";
		Assertions.assertEquals(expected, appender.toString());
	}
}
