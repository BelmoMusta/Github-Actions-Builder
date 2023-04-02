package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

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
	}@Override
	public void accept(VoidVisitor visitor) {
		visitor.visit(this);
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
