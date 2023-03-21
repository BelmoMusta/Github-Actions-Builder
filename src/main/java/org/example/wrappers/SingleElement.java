package org.example.wrappers;

import org.example.Appender;

public class SingleElement extends Bridge {
	public final String value;
	public final boolean preAppend;
	
	public SingleElement(String value, boolean preAppend) {
		this.value = value;
		this.preAppend = preAppend;
	}
	
	public SingleElement(String value) {
		this(value, false);
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
	
	@Override
	protected boolean addColumn() {
		return true;
	}
}
