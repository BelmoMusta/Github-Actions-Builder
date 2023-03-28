package org.example;

import org.example.collections.SubNode;
import org.example.visitor.Visitor;
import org.example.wrappers.NameValuePair;

public class Step extends SubNode {
	
	protected Step(String name) {
		super(name, true);
	}
	
	public static Step name(String name) {
		return new Step(name);
	}
	
	public Step uses(String s) {
		this.add(new NameValuePair("uses", s));
		return this;
	}
	
	public Step run(String s) {
		this.add( new NameValuePair("run", s));
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
