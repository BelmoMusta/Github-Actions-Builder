package org.example.wrappers;

import org.example.Appender;

public class DashSingleElement extends NameValuePair {
	public DashSingleElement(String value) {
		super(null, value);
	}
	
	@Override
	public String toString() {
		Appender appender = preAppend();
		appender.append("- ");
		appender.append("'");
		appender.append(value);
		appender.append("'");
		return appender.toString();
	}
}
