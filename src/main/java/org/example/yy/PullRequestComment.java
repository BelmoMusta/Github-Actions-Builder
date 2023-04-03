package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

public class PullRequestComment extends WorkflowEvent {
	
	protected PullRequestComment() {
		super("pull_request_comment");
	}
	
	public static PullRequestComment $() {
		return new PullRequestComment();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	@Override
	public void accept(VoidVisitor<?> visitor) {
		visitor.visit(this);
	}
}
