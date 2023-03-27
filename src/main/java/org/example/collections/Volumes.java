package org.example.collections;

import org.example.visitor.Visitor;

public class Volumes extends SubNode {
	public Volumes() {
		super("volumes");
	}
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
