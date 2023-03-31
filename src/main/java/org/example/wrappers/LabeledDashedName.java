package org.example.wrappers;

import org.example.visitor.Visitor;

public class LabeledDashedName extends LabeledName {
	public LabeledDashedName(String value) {
		super(value);
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
