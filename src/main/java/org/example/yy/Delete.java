package org.example.yy;

import org.example.visitor.Visitor;

public class Delete extends WorkflowEvent {
	public Delete() {
		super("delete");
	}
	
	public static Delete $() {
		return new Delete();
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
}
