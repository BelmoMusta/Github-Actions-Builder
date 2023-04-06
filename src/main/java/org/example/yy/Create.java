package org.example.yy;

import org.example.visitor.Visitor;

public class Create extends WorkflowEvent {
	public Create() {
		super("create");
	}
	
	public static Create $() {
		return new Create();
	}
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
