package org.example.collections;

import org.example.visitor.Visitor;

public class Outputs extends Nodes {
	public Outputs() {
		super("outputs");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
