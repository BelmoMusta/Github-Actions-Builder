package org.example.yy;

import org.example.collections.Nodes;
import org.example.visitor.Visitor;

public class Defaults extends Nodes {
	protected Defaults() {
		super("defaults");
	}
	
	public static Defaults $() {
		return new Defaults();
	}
	public Defaults run(Run run){
		add(run);
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
