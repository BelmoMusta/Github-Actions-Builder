package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

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
	}@Override
	public void accept(VoidVisitor<?>visitor) {
		visitor.visit(this);
	}
}
