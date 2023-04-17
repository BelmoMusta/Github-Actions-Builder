package org.example.wrappers.leaves;

import org.example.visitor.Visitor;

public class InOutElement<T> extends NameValuePair {
	T inputValue;
	
	public InOutElement(String name, T value) {
		super(name, String.valueOf(value));
		this.inputValue = value;
	}
	
	public boolean withDoubleQuotes() {
		return false;
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
}
