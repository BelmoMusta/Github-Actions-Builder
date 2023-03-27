package org.example.collections;

import org.example.visitor.Visitor;

public class Events extends Nodes {
	
	public Events() {
		super("on");
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg );
	}
}
