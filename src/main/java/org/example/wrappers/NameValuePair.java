package org.example.wrappers;

import org.example.Appender;

public class NameValuePair extends Tag {
	public String name;
	public String value;
	
	public NameValuePair() {
	
	}
	
	public NameValuePair(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		if (addDashAtFirst()) {
			appender.append("- ");
		}
		appender.append(name);
		appender.append(":");
		if (addSpace()) {
			appender.append(" ");
		}
		if (wrapValueWithQuotes()) {
			appender.appendSingleQuote(value);
		} else {
			appender.append(value);
			
		}
		return appender.toString();
	}
	
	public boolean addDashAtFirst() {
		return false;
	}
	
	public boolean addSpace() {
		return true;
	}
	
	public boolean wrapValueWithQuotes() {
		return false;
	}
	
	@Override
	public String get() {
		return value;
	}
	
}
