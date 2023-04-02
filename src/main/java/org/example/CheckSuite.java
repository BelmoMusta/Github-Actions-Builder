package org.example;

import org.example.visitor.Visitor;

public class CheckSuite extends WorkflowEvent {
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
