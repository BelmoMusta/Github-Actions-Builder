package org.example.collections;

import org.example.visitor.Visitor;

public class Withs extends SubNode {
	public Withs() {
		super("with");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
