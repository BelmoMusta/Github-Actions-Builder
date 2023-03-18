package org.example;

import org.example.collections.Branches;
import org.example.collections.Types;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.Indentable;
import org.example.wrappers.SimpleName;

import java.util.Arrays;
import java.util.List;

public class PullRequest extends WorkflowEvent {
	final Types types = new Types();
	final Branches branches = new Branches();
	final SimpleName name = new SimpleName("pull_request");
	
	public static PullRequest $() {
		return new PullRequest();
	}
	
	public static PullRequest types(String... types) {
		final PullRequest pullRequest = new PullRequest();
		for (String type : types) {
			DashSingleElement element = new DashSingleElement(type);
			pullRequest.types.add(element);
		}
		return pullRequest;
	}
	
	public PullRequest branches(String... branches) {
		for (String branch : branches) {
			DashSingleElement br = new DashSingleElement(branch);
			this.branches.add(br);
		}
		return this;
	}
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		name.setIndentLevel(getIndentLevel());
		types.setIndentLevel(getIndentLevel() + 1);
		branches.setIndentLevel(getIndentLevel() + 1);
	}
	
	@Override
	protected List<Indentable> getIndentables() {
		return Arrays.asList(name, types, branches);
	}
}
