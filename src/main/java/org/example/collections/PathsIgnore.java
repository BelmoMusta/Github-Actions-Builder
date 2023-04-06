package org.example.collections;

import org.example.visitor.Visitor;

public class PathsIgnore extends Nodes {
	public PathsIgnore() {
		super("paths-ignore");
	}
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	
}
