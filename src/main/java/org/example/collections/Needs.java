package org.example.collections;

import org.example.visitor.Visitor;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.Node;

import java.util.Arrays;

public class Needs extends SubNode {
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
}
