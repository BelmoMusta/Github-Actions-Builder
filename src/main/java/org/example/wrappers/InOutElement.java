package org.example.wrappers;

import org.example.visitor.Visitor;

public class InOutElement<T> extends NameValuePair {
	T inputValue;
	public InOutElement(String name, T value) {
		this.name = name;
		this.inputValue = value;
		super.value = String.valueOf(value);
	}
	
	
	public boolean withDoubleQuotes() {
		return false;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
