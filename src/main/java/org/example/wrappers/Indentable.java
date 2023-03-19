package org.example.wrappers;

import org.example.Appender;

public class Indentable implements Tag {
	private int indentLevel;
	
	@Override
	public void setIndentLevel(int indentLvel) {
		this.indentLevel = indentLvel;
	}
	
	public int getIndentLevel() {
		return indentLevel;
	}
	
	public void incrementIndentation() {
		indentLevel++;
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
