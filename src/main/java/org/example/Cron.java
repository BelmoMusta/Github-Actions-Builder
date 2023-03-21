package org.example;

import org.example.wrappers.Indentable;

public class Cron extends Indentable {
	String value;
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		appender.append("- cron: ").appendSingleQuote(value);
		return appender.toString();
	}
}
