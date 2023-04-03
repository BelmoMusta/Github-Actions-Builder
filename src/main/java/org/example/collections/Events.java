package org.example.collections;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

public class Events extends Nodes {
	
	public Events() {
		super("on");
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg );
	}
	
	@Override
	public void accept(VoidVisitor<?>visitor) {
		visitor.visit(this);
	}
}
