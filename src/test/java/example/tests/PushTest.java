package example.tests;

import org.example.Appender;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
import org.example.yy.Push;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PushTest {
	@Test
	public void test() {
		Push push = Push.$();
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		push.accept(visitor, appender);
		String expected = "push:";
		Assertions.assertEquals(expected, appender.toString());
	}
 
	
	@Test
	public void testBranches() {
		Push push = Push.$()
				.branches("a", "b")
				.branchesIgnore("c", "d");
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		push.accept(visitor, appender);
		String expected = "push:\n" +
				"  branches:\n" +
				"    - 'a'\n" +
				"    - 'b'\n" +
				"  branches-ignore:\n" +
				"    - 'c'\n" +
				"    - 'd'";
		Assertions.assertEquals(expected, appender.toString());
	}
	@Test
	public void testBranchesIgnore() {
		Push push = Push.$()
				.branchesIgnore("c", "d");
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		push.accept(visitor, appender);
		String expected = "push:\n" +
				"  branches-ignore:\n" +
				"    - 'c'\n" +
				"    - 'd'";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	
	@Test
	public void testPaths() {
		Push push = Push.$()
				.paths("a/n", "b/c");
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		push.accept(visitor, appender);
		String expected = "push:\n" +
				"  paths:\n" +
				"    - 'a/n'\n" +
				"    - 'b/c'";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testPathsIgnore() {
		Push push = Push.$()
				.pathsIgnore("e/m")
				.pathsIgnore("f/j");
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		push.accept(visitor, appender);
		String expected = "push:\n" +
				"  paths-ignore:\n" +
				"    - 'e/m'\n" +
				"    - 'f/j'";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testTags() {
		Push push = Push.$()
				.tags("a/n", "b/c");
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		push.accept(visitor, appender);
		String expected = "push:\n" +
				"  tags:\n" +
				"    - 'a/n'\n" +
				"    - 'b/c'";
		Assertions.assertEquals(expected, appender.toString());
	}
	@Test
	public void testTagsIgnore() {
		Push push = Push.$()
				.tagsIgnore("a/n", "b/c");
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		push.accept(visitor, appender);
		String expected = "push:\n" +
				"  tags-ignore:\n" +
				"    - 'a/n'\n" +
				"    - 'b/c'";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	
}
