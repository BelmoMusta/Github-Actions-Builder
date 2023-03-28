package org.example;

import org.example.visitor.Visitor;

public class PullRequestTarget extends WorkflowEvent {
	
	protected PullRequestTarget() {
		super("pull_request_target");
	}
	public static PullRequestTarget $() {
		return new PullRequestTarget();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
