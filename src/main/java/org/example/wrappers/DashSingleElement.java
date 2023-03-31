package org.example.wrappers;

import org.example.visitor.Visitor;

public class DashSingleElement extends SingleElement {
	public DashSingleElement(String value) {
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
