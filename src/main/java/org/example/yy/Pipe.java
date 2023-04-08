package org.example.yy;

import org.example.collections.Nodes;
import org.example.visitor.Visitor;
import org.example.wrappers.leaves.SimpleEntry;

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
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
}
