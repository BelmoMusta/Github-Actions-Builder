package org.example;

import org.example.collections.Nodes;

public abstract class WorkflowEvent extends Nodes {
	
	protected WorkflowEvent(String name) {
		super(name);
	}
	
	@Override
	protected boolean acceptEmptyCollection() {
		return true;
	}
}
