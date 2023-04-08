package org.example.wrappers.leaves;

import org.example.visitor.Visitor;

public class DashQuotedSingleElement extends DashSingleElement {
	public DashQuotedSingleElement(String value) {
		super(value);
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
}
