package org.example.wrappers;

public class Bridge extends Tag {
	protected boolean addColumn() {
		return false;
	}
	
	public boolean addDashAtFirst() {
		return false;
	}
	
	public boolean wrapValueWithQuotes() {
		return false;
	}
	
}
