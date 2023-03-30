package org.example;

import org.example.collections.Environments;
import org.example.collections.SubNode;
import org.example.collections.Withs;
import org.example.visitor.Visitor;
import org.example.wrappers.Id;
import org.example.wrappers.LabeledName;
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
	
	public Step if_(String condition) {
		add(new NameValuePair("if", condition));
		return this;
	}
	
	public Step env(String name, String value) {
		
		Environments environments = findTag(Environments.class);
		if (environments == null) {
			environments = new Environments();
			add(environments);
		}
		Environment environment = new Environment(name, value);
		environments.add(environment);
		return this;
	}
	
	public Step with(String name, String value) {
		
		Withs withs = findTag(Withs.class);
		if (withs == null) {
			withs = new Withs();
			add(withs);
		}
		With with = new With(name, value);
		withs.add(with);
		return this;
	}
		public Step with(String name, Pipe value) {
		
		Withs withs = findTag(Withs.class);
		if (withs == null) {
			withs = new Withs();
			add(withs);
		}
		With with = new With(name, "|");
		withs.add(with);
		withs.add(value);
		return this;
	}
	
	public Step name(String name) {
		this.add(new LabeledName(name));
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
