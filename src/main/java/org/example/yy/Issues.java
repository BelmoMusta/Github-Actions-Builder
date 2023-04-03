package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.yy.support.TypesSupport;

public class Issues extends WorkflowEvent implements TypesSupport {
	public Issues() {
		super("issues");
	}
	
	public static Issues $() {
		return new Issues();
	}
	
	public Issues types(Issues.Type... types) {
		return addTypes(this, types);
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
		
		ASSIGNED,
		CLOSED,
		DELETED,
		DEMILESTONED,
		EDITED,
		LABELED,
		LOCKED,
		MILESTONED,
		OPENED,
		PINNED,
		REOPENED,
		TRANSFERRED,
		UNASSIGNED,
		UNLABELED,
		UNLOCKED,
		UNPINNED,
		
		;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}
