package org.example.wrappers.leaves;

import org.example.visitor.Visitor;

public class LabeledName extends NameValuePair {
	public LabeledName(String value) {
		super("name", value);
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
}
