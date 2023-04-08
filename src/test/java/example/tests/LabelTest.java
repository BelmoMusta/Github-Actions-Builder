package example.tests;

import org.example.yy.Label;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LabelTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Label label = Label.$();
		label.accept(visitor);
		String expected = "label:";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testTypes() {
		Label release = Label.$()
				.types(Label.Type.CREATED)
				.types(Label.Type.DELETED)
				.types(Label.Type.EDITED);
		release.accept(visitor);
		String expected = "label:\n" +
				"  types:\n" +
				"    - created\n" +
				"    - deleted\n" +
				"    - edited";
		Assertions.assertEquals(expected, visitor.getResult());
	}
}
