package org.example.collections;

import org.example.visitor.Visitor;
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
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	
}
