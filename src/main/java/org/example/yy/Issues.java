package org.example.yy;

import org.example.visitor.Visitor;
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
	public <R> void accept(Visitor<R> visitor) {
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
