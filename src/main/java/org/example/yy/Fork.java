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
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
