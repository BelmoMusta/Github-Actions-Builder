package org.example.wrappers;

import org.example.visitor.Visitor;

public class UnknownTag extends Tag {
	
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		System.err.println(get());
		super.accept(visitor);
	}
	
}
