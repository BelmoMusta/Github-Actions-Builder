package org.example.collections;

import org.example.visitor.Visitor;

public class Tags extends SubNode {
	public Tags() {
		super("tags");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
