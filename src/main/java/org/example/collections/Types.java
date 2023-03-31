package org.example.collections;

import org.example.visitor.Visitor;

public class Types extends Nodes {
	public Types() {
		super("types");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
