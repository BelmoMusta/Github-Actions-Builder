package org.example.wrappers;

public class DashedNameValuePair extends NameValuePair {
	
	public DashedNameValuePair(String name, String value) {
		super(name, value);
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
