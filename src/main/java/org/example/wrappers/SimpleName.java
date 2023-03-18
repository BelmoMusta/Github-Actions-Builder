package org.example.wrappers;

import org.example.Appender;

public class SimpleName extends Indentable {
	public final String value;
	
	public SimpleName(String value) {this.value = value;}
	
	@Override
	public String toString() {
		Appender appender = preAppend();
		appender.append(value);
		appender.append(":");
		return appender.toString();
	}
}
