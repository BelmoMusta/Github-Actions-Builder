package org.example.wrappers;

import org.example.visitor.Visitor;

public abstract class Tag implements Node {
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
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg );
	}
}
