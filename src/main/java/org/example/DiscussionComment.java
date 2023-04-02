package org.example;

import org.example.visitor.Visitor;

public class DiscussionComment extends WorkflowEventWithBranches {
	public DiscussionComment() {
		super("discussion_comment");
	}
	
	public static DiscussionComment $() {
		return new DiscussionComment();
	}
	
	public DiscussionComment types(DiscussionComment.Type... types) {
		return addTypes(this, types);
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
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
