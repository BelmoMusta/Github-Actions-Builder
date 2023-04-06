package org.example.wrappers;

import org.example.visitor.Visitor;

public class DashQuotedSingleElement extends DashSingleElement {
	public DashQuotedSingleElement(String value) {
		super(value);
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
