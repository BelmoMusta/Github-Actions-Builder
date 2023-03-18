package org.example;

import org.example.wrappers.NameValuePair;

public class Environment extends NameValuePair {
	
	public Environment(String name, String value) {
		super(name, value);
	}
	
	
	public Environment env(String name, String value) {
		return new Environment(name, value);
	}
	
	@Override
	public String toString() {
		return name + ": " + value;
	}
}
