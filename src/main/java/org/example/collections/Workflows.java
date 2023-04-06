package org.example.collections;

import org.example.visitor.Visitor;

public class Workflows extends Nodes {
	public Workflows() {
		super("workflows");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
}
