package org.example.collections;

import org.example.visitor.Visitor;

public class BranchesIgnore extends SubNode {
	public BranchesIgnore() {
		super("branches-ignore");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
