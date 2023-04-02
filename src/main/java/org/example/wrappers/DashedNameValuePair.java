package org.example.wrappers;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

public class DashedNameValuePair extends NameValuePair {
	
	public DashedNameValuePair(String name, String value) {
		super(name, value);
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
