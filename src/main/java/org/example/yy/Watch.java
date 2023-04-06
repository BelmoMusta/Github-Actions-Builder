package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class Watch extends WorkflowEvent implements TypesSupport {
	
	protected Watch() {
		super("watch");
	}
	
	public Watch types(Type... types) {
		return addTypes(this, types);
	}
	
	public static Watch $() {
		return new Watch();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	public enum Type implements TypeI {
		STARTED,
		
		;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}
