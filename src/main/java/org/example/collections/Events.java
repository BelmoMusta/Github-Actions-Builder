package org.example.collections;

import org.example.visitor.Visitor;

public class Events extends Nodes {
	
	public Events() {
		super("on");
	}
	
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	
}
