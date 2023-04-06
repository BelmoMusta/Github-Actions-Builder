package org.example.yy;

import org.example.visitor.Visitor;

public class Public extends WorkflowEvent {
	public Public() {
		super("public");
	}
	
	public static Public $() {
		return new Public();
	}
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
