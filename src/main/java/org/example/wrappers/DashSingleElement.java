package org.example.wrappers;

import org.example.Appender;
import org.example.wrappers.NameValuePair;

public class DashSingleElement extends NameValuePair {
	public DashSingleElement(String value) {
		this.value = value;
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
