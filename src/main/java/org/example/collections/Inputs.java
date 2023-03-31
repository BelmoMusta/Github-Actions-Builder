package org.example.collections;

import org.example.visitor.Visitor;

public class Inputs extends Nodes {
	public Inputs() {
		super("inputs");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
