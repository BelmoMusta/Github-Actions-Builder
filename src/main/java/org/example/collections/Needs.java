package org.example.collections;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.wrappers.Node;

public class Needs extends Nodes {
	public Needs() {
		super("needs");
	}
	
	@Override
	public void add(Node tag) {
		/**
		 * do not add the same tag more than once
		 */
		for (Node node : children) {
			if (node.get().equals(tag.get())) {
				return;
			}
		}
		super.add(tag);
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	@Override
	public void accept(VoidVisitor visitor) {
		visitor.visit(this);
	}
}
