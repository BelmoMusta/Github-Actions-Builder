package org.example.collections;

import org.example.visitor.Visitor;

public class Types extends SubNode {
	public Types() {
		super("types");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
