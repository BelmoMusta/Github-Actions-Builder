package example.tests;

import org.example.yy.PageBuild;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PageBuildTest extends AbstracTest {
	
	@Test
	public void initTest() {
		PageBuild pageBuild = PageBuild.$();
		pageBuild.accept(visitor);
		String expected = "page_build:";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
}
