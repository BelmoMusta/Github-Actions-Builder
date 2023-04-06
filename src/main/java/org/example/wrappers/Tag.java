package org.example.wrappers;

import org.example.visitor.ValuedVisitor;
import org.example.visitor.Visitor;

public abstract class Tag implements Node {
	
	@Override
	public String get() {
		return "";
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		//
	}
	
	@Override
	public <A, R> R accept(ValuedVisitor<A, R> visitor, A arg) {
		return null;
	}
}
