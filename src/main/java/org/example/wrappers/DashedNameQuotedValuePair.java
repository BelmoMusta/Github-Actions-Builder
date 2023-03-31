package org.example.wrappers;

import org.example.visitor.Visitor;

public class DashedNameQuotedValuePair extends DashedNameValuePair {
	
	public DashedNameQuotedValuePair(String name, String value) {
		super(name, value);
	}
	
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
