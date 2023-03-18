package org.example.wrappers;

import org.example.Appender;

public class SingleElement extends Indentable {
	public final String value;
	
	public SingleElement(String value) {this.value = value;}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		appender.indent(getIndentLevel());
		appender.append(value);
		appender.append(":");
		appender.newLine();
		
		return appender.toString();
	}
}
