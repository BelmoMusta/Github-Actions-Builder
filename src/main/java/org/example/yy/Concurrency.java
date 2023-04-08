package org.example.yy;

import org.example.collections.Nodes;
import org.example.visitor.Visitor;
import org.example.wrappers.leaves.NameValuePair;

public class Concurrency extends Nodes {
	
	protected Concurrency() {
		super("concurrency");
	}
	
	public static Concurrency $() {
		return new Concurrency();
	}
	
	public Concurrency group(String group) {
		add(new NameValuePair("group", group));
		return this;
	}
	
	public Concurrency cancelInProgress(boolean cancel) {
		add(new NameValuePair("cancel-in-progress", String.valueOf(cancel)));
		return this;
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
}
