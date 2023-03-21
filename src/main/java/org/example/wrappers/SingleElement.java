package org.example.wrappers;

import org.example.Appender;

public class SingleElement extends NameValuePair {
	public final String value;
	
	
	public SingleElement(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		
		if (addDashAtFirst()) {
			appender.append("- ");
		}
		if (wrapValueWithQuotes()) {
			appender.appendSingleQuote(value);
		} else {
			appender.append(value);
		}
		if (addColumn()) {
			appender.append(":");
		}
		return appender.toString();
	}
	
	protected boolean addColumn() {
		return true;
	}
}
