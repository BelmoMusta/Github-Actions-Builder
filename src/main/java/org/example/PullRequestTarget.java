package org.example;

public class PullRequestTarget extends WorkflowEvent {
	
	protected PullRequestTarget() {
		super("pull_request_target");
	}
	public static PullRequestTarget $() {
		return new PullRequestTarget();
	}
}
