package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.yy.support.TypesSupport;

public class PullRequestReview extends WorkflowEvent implements TypesSupport {
	
	protected PullRequestReview() {
		super("pull_request_review");
	}
	
	public PullRequestReview types(Type... types) {
		return addTypes(this, types);
	}
	
	public static PullRequestReview $() {
		return new PullRequestReview();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	@Override
	public void accept(VoidVisitor<?> visitor) {
		visitor.visit(this);
	}
	
	public enum Type implements TypeI {
		DISMISSED,
		EDITED,
		SUBMITTED,
		
		;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}
