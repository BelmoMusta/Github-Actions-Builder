package org.example.wrappers;

public class DashQuotedSingleElement extends DashSingleElement {
	public DashQuotedSingleElement(String value) {
		super(value);
	}
	
	@Override
	public boolean addDashAtFirst() {
		return true;
	}
	
	@Override
	public boolean wrapValueWithQuotes() {
		return true;
	}
}
