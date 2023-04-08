package org.example.collections;

import org.example.visitor.Visitor;

public class Secrets extends Nodes {
	public Secrets() {
		super("secrets");
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	
}
