package org.example.collections;

import org.example.visitor.Visitor;

public class Jobs extends Nodes {
	public Jobs() {
		super("jobs");
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	
}
