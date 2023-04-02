package org.example;

import org.example.visitor.Visitor;

public class CheckRun extends WorkflowEvent {
	public CheckRun() {
		super("check_run");
	}
	
	public static CheckRun $() {
		return new CheckRun();
	}
	
	public CheckRun types(CheckRun.Type... types) {
		return addTypes(this, types);
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	public enum Type implements TypeI {
		
		COMPLETED,
		CREATED,
		REQUESTED_ACTION,
		REREQUESTED,
		
		;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}
