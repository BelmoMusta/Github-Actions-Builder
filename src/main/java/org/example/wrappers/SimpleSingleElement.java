package org.example.wrappers;

public class SimpleSingleElement extends SingleElement {
	public SimpleSingleElement(String value) {
		super(value);
	}
	@Override
	public boolean wrapValueWithQuotes() {
		return false;
	}
	
	@Override
	protected boolean addColumn() {
		return false;
	}
}
