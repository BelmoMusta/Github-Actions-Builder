package org.example.wrappers;

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
	
}
