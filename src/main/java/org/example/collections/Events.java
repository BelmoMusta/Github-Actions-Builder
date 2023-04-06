package org.example.collections;

import org.example.visitor.Visitor;

public class Events extends Nodes {
	
	public Events() {
		super("on");
	}
	
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg );
	}
	
	
}
