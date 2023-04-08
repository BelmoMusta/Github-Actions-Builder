package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class PullRequestReviewComment extends WorkflowEvent implements TypesSupport {
	
	protected PullRequestReviewComment() {
		super("pull_request_review_comment");
	}
	
	public PullRequestReviewComment types(Type... types) {
		return addTypes(this, types);
	}
	
	public static PullRequestReviewComment $() {
		return new PullRequestReviewComment();
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	public enum Type implements TypeI {
		CREATED,
		DELETED,
		EDITED,
		
		;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}
