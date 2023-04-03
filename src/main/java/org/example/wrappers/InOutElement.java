package org.example.wrappers;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

public class InOutElement<T> extends NameValuePair {
	T inputValue;
	public InOutElement(String name, T value) {
		this.name = name;
		this.inputValue = value;
		super.value = String.valueOf(value);
	}
	
	public boolean isString() {
		return inputValue instanceof String;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}@Override
	public void accept(VoidVisitor<?>visitor) {
		visitor.visit(this);
	}
}
