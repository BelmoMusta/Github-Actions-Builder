package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

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
	}@Override
	public void accept(VoidVisitor visitor) {
		visitor.visit(this);
	}
}
