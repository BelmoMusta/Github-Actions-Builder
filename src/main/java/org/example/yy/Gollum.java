package org.example.yy;

import org.example.visitor.Visitor;

public class Gollum extends WorkflowEvent {
	public Gollum() {
		super("gollum");
	}
	
	public static Gollum $() {
		return new Gollum();
	}
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
