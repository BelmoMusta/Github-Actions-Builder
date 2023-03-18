package org.example;

import org.example.wrappers.Indentable;

public class Branch extends Indentable {
	private String name;
	
	public Branch(String branch) {
		this.name = branch;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		appender.indent(getIndentLevel());
 		appender.append("- ");
		appender.append(name);
		return appender.toString();
	}
}
