package org.example;

import org.example.collections.Branches;
import org.example.wrappers.DashQuotedSingleElement;

public abstract class WorkflowEventWithBranches extends WorkflowEvent {
	
	protected WorkflowEventWithBranches(String name) {
		super(name);
	}
	
	protected WorkflowEventWithBranches(String name, String... branches) {
		super(name);
		final Branches innerBranches = new Branches();
		for (String branch : branches) {
			innerBranches.add(new DashQuotedSingleElement(branch));
		}
		add(innerBranches);
	}
}
