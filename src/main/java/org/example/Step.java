package org.example;

import org.example.collections.SubNode;
import org.example.visitor.Visitor;
import org.example.wrappers.Id;
import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.NameValuePair;

public class Step extends SubNode {
	
	protected Step(String name) {
		super(name, true);
	}
	
	protected Step() {
		super(null, true);
	}
	
	public static Step $() {
		return new Step();
	}
	
	public Step id(String name) {
		this.add(new Id(name));
		return this;
	}
	
	public Step name(String name) {
		this.name = new LabeledDashedName(name);
		return this;
	}
	
	public Step uses(String s) {
		this.add(new NameValuePair("uses", s));
		return this;
	}
	
	public Step run(String s) {
		this.add(new NameValuePair("run", s));
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
