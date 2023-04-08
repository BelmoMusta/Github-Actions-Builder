package example.tests;

import org.example.yy.MergeGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeGroupTest extends AbstracTest {
	
	@Test
	public void initTest() {
		MergeGroup mergeGroup = MergeGroup.$();
		mergeGroup.accept(visitor);
		String expected = "merge_group:";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void releaseTypesTest() {
		MergeGroup release = MergeGroup.$()
				.types(MergeGroup.Type.CHECKS_REQUESTED);
		release.accept(visitor);
		String expected = "merge_group:\n" +
				"  types:\n" +
				"    - checks_requested";
		Assertions.assertEquals(expected, visitor.getResult());
	}
}
