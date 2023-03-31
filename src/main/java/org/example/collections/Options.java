package org.example.collections;

import org.example.visitor.Visitor;
import org.example.wrappers.DashQuotedSingleElement;
import org.example.wrappers.DashSingleElement;

public class Options extends Nodes {
	
	public Options() {
		super("options");
	}
	
	public void addAll(String... options) {
		for (String option : options) {
			DashSingleElement element = new DashQuotedSingleElement(option);
			super.add(element);
		}
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
