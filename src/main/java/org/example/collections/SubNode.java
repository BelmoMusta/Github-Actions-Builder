package org.example.collections;

import org.example.visitor.Visitor;

public abstract class SubNode extends Nodes {
	protected SubNode(String name) {
		super(name);
	}
	protected SubNode(String name, boolean nameWithDash) {
		super(name, nameWithDash);
	}
	
	
}
