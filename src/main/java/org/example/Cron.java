package org.example;

import org.example.wrappers.Tag;

public class Cron extends Tag {
	String value;
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		appender.append("- cron: ").appendSingleQuote(value);
		return appender.toString();
	}
}
