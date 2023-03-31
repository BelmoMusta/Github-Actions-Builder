package org.example;

import org.example.visitor.Visitor;
import org.example.wrappers.NameValuePair;

public class Volume extends NameValuePair {
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
