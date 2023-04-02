package org.example.wrappers;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

public class SingleElement extends NameValuePair {
	
	public SingleElement(String value) {
		this.value = value;
	}
	
	public boolean addColumn() {
		return true;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	@Override
	public void accept(VoidVisitor visitor) {
		visitor.visit(this);
	}
}
