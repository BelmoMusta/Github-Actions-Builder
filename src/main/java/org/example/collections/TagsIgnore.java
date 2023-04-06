package org.example.collections;

import org.example.visitor.Visitor;

public class TagsIgnore extends Nodes {
	public TagsIgnore() {
		super("tags-ignore");
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	
}
