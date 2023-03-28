package org.example.wrappers;

import org.example.visitor.Visitor;

public abstract class Tag implements Node {
	
	@Override
	public boolean isNotEmpty() {
		return true;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg );
	}
}
