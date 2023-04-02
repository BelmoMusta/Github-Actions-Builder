package org.example.collections;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

public class Inputs extends Nodes {
	public Inputs() {
		super("inputs");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	@Override
	public void accept(VoidVisitor visitor) {
		visitor.visit(this);
	}
}
