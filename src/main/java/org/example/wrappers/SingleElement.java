package org.example.wrappers;

import org.example.visitor.Visitor;

public class SingleElement extends NameValuePair {
	
	public SingleElement(String value) {
		this.value = value;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	
}
