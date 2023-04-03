package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

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
	}@Override
	public void accept(VoidVisitor<?>visitor) {
		visitor.visit(this);
	}
}
