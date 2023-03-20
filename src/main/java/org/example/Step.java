package org.example;

import org.example.collections.AbstractCollection;
import org.example.wrappers.NameValuePair;

public class Step extends AbstractCollection {
	
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
	
}
