package org.example.wrappers;

import org.example.visitor.Visitor;

public class LabeledName extends NameValuePair {
	public LabeledName(String value) {
		super("name", value);
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
