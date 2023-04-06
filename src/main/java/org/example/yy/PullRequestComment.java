package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class PullRequestComment extends WorkflowEvent implements  TypesSupport {
	
	protected PullRequestComment() {
		super("pull_request_comment");
	}
	
	public PullRequestComment types(Type ... types){
		return addTypes(this, types);
	}
	
	public static PullRequestComment $() {
		return new PullRequestComment();
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
