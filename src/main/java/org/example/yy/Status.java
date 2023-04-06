package org.example.yy;

import org.example.visitor.Visitor;

public class Status extends WorkflowEvent {
	public Status() {
		super("status");
	}
	
	public static Status $() {
		return new Status();
	}
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
