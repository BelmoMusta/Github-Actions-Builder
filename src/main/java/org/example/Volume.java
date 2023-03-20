package org.example;

import org.example.wrappers.NameValuePair;

public class Volume extends NameValuePair {
	@Override
	public boolean addDashAtFirst() {
		return true;
	}
	
	@Override
	public boolean addSpace() {
		return false;
	}
}
