package org.example.wrappers;

import org.example.visitor.Visitor;

public class UnknownTag extends Tag {
	
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		super.accept(visitor, arg);
		System.err.println(get());
	}
	
}
