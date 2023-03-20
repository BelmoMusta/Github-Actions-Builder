package org.example.wrappers;

public class DashSingleElement extends SingleElement {
	public DashSingleElement(String value) {
		super(value);
	}
	
	@Override
	public boolean addDashAtFirst() {
		return true;
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
