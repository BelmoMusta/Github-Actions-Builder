package org.example.wrappers;

public class Bridge extends Indentable {
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
