package org.example.collections;

import org.example.visitor.Visitor;

public class Jobs extends Nodes {
	public Jobs() {
		super("jobs");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	
}
