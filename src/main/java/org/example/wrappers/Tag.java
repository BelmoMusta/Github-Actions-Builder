package org.example.wrappers;

import org.example.visitor.Visitor;

public abstract class Tag implements Node {
	
	@Override
	public String get() {
		return "[Unknown-tag]";
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		//
	}
	
	
}
