package org.example.collections;

import org.example.visitor.Visitor;

public class Branches extends Nodes {
	public Branches() {
		super("branches");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
}
