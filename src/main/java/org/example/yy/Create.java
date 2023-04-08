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
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
}
