package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class CheckSuite extends WorkflowEvent implements TypesSupport {
	public CheckSuite() {
		super("check_suite");
	}
	
	public static CheckSuite $() {
		return new CheckSuite();
	}
	
	public CheckSuite types(CheckSuite.Type... types) {
		return addTypes(this, types);
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
	
	public enum Type implements TypeI {
		COMPLETED,
		;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}
