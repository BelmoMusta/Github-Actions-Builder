package org.example.wrappers;

public class DashedNameValuePair extends NameValuePair {
	
	public DashedNameValuePair(String name, String value) {
		super(name, value);
	}
	
	public boolean addDashAtFirst() {
		return true;
	}
	
	public boolean wrapValueWithQuotes() {
		return true;
	}
}
