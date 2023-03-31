package org.example.wrappers;

import org.example.visitor.Visitor;

public class SimpleSingleElement extends SingleElement {
	public SimpleSingleElement(String value) {
		super(value);
	}
	
	@Override
	public boolean addColumn() {
		return false;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
