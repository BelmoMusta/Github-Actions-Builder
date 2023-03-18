package org.example.wrappers;

public enum Type{
	choice,
	environment,
	boolean_,
	string_;
	
	@Override
	public java.lang.String toString() {
		return super.toString().replace("_", "");
	}
}