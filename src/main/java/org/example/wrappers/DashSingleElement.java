package org.example.wrappers;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

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
	}@Override
	public void accept(VoidVisitor<?>visitor) {
		visitor.visit(this);
	}
}
