package example.tests;

import org.example.DeploymentStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class DeploymentStatusTest extends AbstracTest {
	
	@Test
	public void initTest() {
		DeploymentStatus deployment = DeploymentStatus.$();
		deployment.accept(visitor, appender);
		String expected = "deployment_status:";
		Assertions.assertEquals(expected, appender.toString());
	}
}
