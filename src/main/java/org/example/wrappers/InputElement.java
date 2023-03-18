package org.example.wrappers;

import org.example.Appender;

public class InputElement<T> extends NameValuePair {
	public InputElement(String name, T value) {
		this.name = name;
		String boundary = "";
		if(value instanceof String){
			boundary = "'";
		}
		this.value = boundary + value.toString() + boundary;
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
