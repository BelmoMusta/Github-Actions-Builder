package org.example.collections;

import org.example.visitor.Visitor;

public class Services extends Nodes {
	public Services() {
		super("services");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	
}
