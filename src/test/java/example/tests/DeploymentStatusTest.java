package example.tests;

import org.example.yy.DeploymentStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeploymentStatusTest extends AbstracTest {
	
	@Test
	public void initTest() {
		DeploymentStatus deployment = DeploymentStatus.$();
		deployment.accept(visitor);
		String expected = "deployment_status:";
		Assertions.assertEquals(expected, visitor.getResult());
	}
}
