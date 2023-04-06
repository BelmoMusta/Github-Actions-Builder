package org.example.collections;

import org.example.visitor.Visitor;

public class Tags extends Nodes {
	public Tags() {
		super("tags");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	
}
