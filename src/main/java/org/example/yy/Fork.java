package org.example.yy;

import org.example.visitor.Visitor;

public class Fork extends WorkflowEvent {
	public Fork() {
		super("fork");
	}
	
	public static Fork $() {
		return new Fork();
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
}
