package org.example;

import org.example.visitor.Visitor;

public class Delete extends WorkflowEvent {
	public Delete() {
		super("delete");
	}
	
	public static Delete $() {
		return new Delete();
	}
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
