package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

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
	}@Override
	public void accept(VoidVisitor visitor) {
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
