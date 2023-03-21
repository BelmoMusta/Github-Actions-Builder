package org.example.wrappers;

public class Tag implements Indentable {
	private int indentLevel;
	
	@Override
	public void setIndentLevel(int indentLevel) {
		this.indentLevel = indentLevel;
	}
	
	public int getIndentLevel() {
		return indentLevel;
	}
	
	@Override
	public boolean isNotEmpty() {
		return true;
	}
	
}
