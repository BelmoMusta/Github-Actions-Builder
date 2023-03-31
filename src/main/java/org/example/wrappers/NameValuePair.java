package org.example.wrappers;

import org.example.visitor.Visitor;

public class NameValuePair extends Tag {
	public String name;
	public String value;
	
	public NameValuePair() {
	
	}
	
	public NameValuePair(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String get() {
		return value;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
