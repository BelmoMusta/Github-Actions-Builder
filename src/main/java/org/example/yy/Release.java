package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class Release extends WorkflowEvent implements TypesSupport {
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
	public <R> void accept(Visitor<R> visitor) {
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
