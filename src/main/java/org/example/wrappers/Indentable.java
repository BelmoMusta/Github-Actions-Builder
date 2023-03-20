package org.example.wrappers;

import org.example.Appender;

public class Indentable implements Tag {
	private int indentLevel;
	
	@Override
	public void setIndentLevel(int indentLevel) {
		this.indentLevel = indentLevel;
	}
	
	public int getIndentLevel() {
		return indentLevel;
	}
	
	@Override
	public boolean isEmpty() {
		return false;
	}
	
	public Appender preAppend() {
		Appender appender = new Appender();
		appender.indent(getIndentLevel());
		return appender;
	}
}
