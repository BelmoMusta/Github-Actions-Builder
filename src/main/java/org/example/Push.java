package org.example;

import org.example.collections.Paths;
import org.example.collections.Tags;
import org.example.visitor.Visitor;
import org.example.wrappers.DashQuotedSingleElement;

public class Push extends WorkflowEventWithBranches {
	public Push() {
		super("push");
	}
	
	public static Push $() {
		return new Push();
	}
	protected Push(String... branches) {
		super("push", branches);
	}
	public static Push branches(String... branches) {
		return new Push(branches);
	}
	
	public Push paths(String... paths) {
		final Paths innerPaths = new Paths();
		for (String path : paths) {
			innerPaths.add(new DashQuotedSingleElement(path));
		}
		add(innerPaths);
		return this;
	}
	
	public Push tags(String... tags) {
		final Tags innerTags = new Tags();
		add(innerTags);
		for (String tag : tags) {
			innerTags.add(new DashQuotedSingleElement(tag));
		}
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
