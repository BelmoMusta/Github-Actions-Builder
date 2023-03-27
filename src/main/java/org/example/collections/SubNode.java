package org.example.collections;

import org.example.visitor.Visitor;
import org.example.wrappers.Node;

public abstract class SubNode extends Nodes {
	protected SubNode(String name) {
		super(name);
	}
	protected SubNode(String name, boolean nameWithDash) {
		super(name, nameWithDash);
	}
	@Override
	public void setIndentLevel(int indentLevel) {
		super.setIndentLevel(indentLevel);
		for (Node node : children) {
			node.setIndentLevel(indentLevel + 1);
		}
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
