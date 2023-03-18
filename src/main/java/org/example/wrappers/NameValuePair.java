package org.example.wrappers;

import org.example.Appender;

public class NameValuePair extends Indentable {
	public  String name;
	public  String value;
	public NameValuePair(){}
	public NameValuePair(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String toString() {
		Appender appender = super.preAppend();
		appender.append(name);
		appender.append(": ");
		appender.append(value);
		return appender.toString();
	}
	
}
