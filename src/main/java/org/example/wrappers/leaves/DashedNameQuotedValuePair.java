package org.example.wrappers.leaves;

import org.example.visitor.Visitor;

public class DashedNameQuotedValuePair extends DashedNameValuePair {
	
	public DashedNameQuotedValuePair(String name, String value) {
		super(name, value);
	}
	
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	
}
