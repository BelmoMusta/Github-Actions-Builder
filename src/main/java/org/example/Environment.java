package org.example;

public class Environment extends NameValuePair {
	
	public static Environment init() {
		return new Environment();
	}
	
	public Environment env(String name, String value) {
		this.name = name;
		this.value = value;
		return this;
	}
	
	@Override
	public String toString() {
		return name + ": " + value;
	}
}
