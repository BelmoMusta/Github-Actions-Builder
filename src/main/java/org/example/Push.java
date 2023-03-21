package org.example;

import org.example.collections.Branches;
import org.example.collections.Paths;
import org.example.collections.Tags;
import org.example.wrappers.DashQuotedSingleElement;

public class Push extends WorkflowEvent {
	public Push() {
		super("push");
	}
	
	public static Push $() {
		return new Push();
	}
	
	public static Push branches(String... branches) {
		final Push push = new Push();
		final Branches innerBranches = new Branches();
		
		for (String branch : branches) {
			innerBranches.add(new DashQuotedSingleElement(branch));
		}
		push.add(innerBranches);
		return push;
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
}
