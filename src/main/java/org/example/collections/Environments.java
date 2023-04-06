package org.example.collections;

import org.example.visitor.Visitor;

public class Environments extends Nodes {
	public Environments() {
		super("env");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
}
