package org.example.yy;

import org.example.collections.Nodes;
import org.example.visitor.Visitor;
import org.example.wrappers.SimpleEntry;

public class Pipe extends Nodes {
	
	public Pipe() {
		super(null); // not needed
	}
	
	public static Pipe $() {
		return new Pipe();
	}
	
	public Pipe entries(String... entries) {
		for (String entry : entries) {
			add(new SimpleEntry(entry));
		}
		return this;
	}
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
