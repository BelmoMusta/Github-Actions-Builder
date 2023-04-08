package org.example.collections;

import org.example.visitor.Visitor;
import org.example.wrappers.leaves.DashQuotedSingleElement;
import org.example.wrappers.leaves.DashSingleElement;

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
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	
}
