package org.example;

import org.example.visitor.Visitor;

public class Release extends WorkflowEventWithBranches {
	public Release() {
		super("release");
	}
	
	public static Release $() {
		return new Release();
	}
	
	public Release types(Release.Type... types) {
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
		PRERELEASED,
		PUBLISHED,
		RELEASED,
		UNPUBLISHED,
		
		;
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}
