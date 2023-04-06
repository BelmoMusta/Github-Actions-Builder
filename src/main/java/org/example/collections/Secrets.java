package org.example.collections;

import org.example.visitor.Visitor;

public class Secrets extends Nodes {
	public Secrets() {
		super("secrets");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	
}
