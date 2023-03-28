package org.example.collections;

import org.example.visitor.Visitor;

public class Ports extends SubNode {
	public Ports() {
		super("ports");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
