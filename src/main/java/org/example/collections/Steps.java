package org.example.collections;

import org.example.visitor.Visitor;

public class Steps extends SubNode {
	public Steps() {
		super("steps");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
