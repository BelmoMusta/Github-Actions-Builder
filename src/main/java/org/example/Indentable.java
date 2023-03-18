package org.example;

public class Indentable implements Tag{
	private int indentLevel;
	
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
}
