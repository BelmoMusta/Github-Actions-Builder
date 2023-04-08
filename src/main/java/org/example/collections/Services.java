package org.example.collections;

import org.example.visitor.Visitor;

public class Services extends Nodes {
	public Services() {
		super("services");
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	
}
