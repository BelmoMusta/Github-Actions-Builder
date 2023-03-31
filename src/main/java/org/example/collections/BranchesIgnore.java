package org.example.collections;

import org.example.visitor.Visitor;

public class BranchesIgnore extends Nodes {
	public BranchesIgnore() {
		super("branches-ignore");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
