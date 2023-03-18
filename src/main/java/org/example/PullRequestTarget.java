package org.example;

import org.example.wrappers.Indentable;
import org.example.wrappers.SimpleName;

import java.util.Arrays;
import java.util.List;

public class PullRequestTarget extends WorkflowEvent {
	
	final SimpleName name = new SimpleName("pull_request_target");
	
	public static PullRequestTarget $() {
		return new PullRequestTarget();
	}
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		name.setIndentLevel(getIndentLevel());
	}
	
	@Override
	protected List<Indentable> getIndentables() {
		return Arrays.asList(name);
	}
}
