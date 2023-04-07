package org.example.yy;

import org.example.collections.Nodes;
import org.example.visitor.Visitor;
import org.example.wrappers.NameValuePair;

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
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
