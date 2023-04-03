package example.tests;

import org.example.Appender;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
import org.example.yy.PullRequest;
import org.example.yy.PullRequestTarget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PullRequestTest {
	@Test
	public void testInit() {
		PullRequest pullRequest = PullRequest.$();
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequest.accept(visitor, appender);
		String expected = "pull_request:";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testTypes() {
		PullRequest pullRequest = PullRequest.$()
				.types(PullRequest.Type.values());
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequest.accept(visitor, appender);
		String expected = "pull_request:\n" +
				"  types:\n" +
				"    - assigned\n" +
				"    - auto_merge_disabled\n" +
				"    - auto_merge_enabled\n" +
				"    - closed\n" +
				"    - converted_to_draft\n" +
				"    - edited\n" +
				"    - labeled\n" +
				"    - locked\n" +
				"    - opened\n" +
				"    - ready_for_review\n" +
				"    - reopened\n" +
				"    - review_requested\n" +
				"    - review_request_removed\n" +
				"    - synchronize\n" +
				"    - unassigned\n" +
				"    - unlabeled\n" +
				"    - unlocked";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testBranches() {
		PullRequest pullRequest = PullRequest.$()
				.branches("a", "b")
				.branchesIgnore("c", "d");
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequest.accept(visitor, appender);
		String expected = "pull_request:\n" +
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
		PullRequest pullRequest = PullRequest.$()
				.branchesIgnore("c", "d");
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequest.accept(visitor, appender);
		String expected = "pull_request:\n" +
				"  branches-ignore:\n" +
				"    - 'c'\n" +
				"    - 'd'";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	
	@Test
	public void testPaths() {
		PullRequest pullRequest = PullRequest.$()
				.paths("a/n", "b/c");
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequest.accept(visitor, appender);
		String expected = "pull_request:\n" +
				"  paths:\n" +
				"    - 'a/n'\n" +
				"    - 'b/c'";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testPathsIgnore() {
		PullRequest pullRequest = PullRequest.$()
				.pathsIgnore("e/m")
				.pathsIgnore("f/j");
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		pullRequest.accept(visitor, appender);
		String expected = "pull_request:\n" +
				"  paths-ignore:\n" +
				"    - 'e/m'\n" +
				"    - 'f/j'";
		Assertions.assertEquals(expected, appender.toString());
		
	}
}
