package org.example.collections;

import org.example.visitor.Visitor;

public class Ports extends Nodes {
	public Ports() {
		super("ports");
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	
}
