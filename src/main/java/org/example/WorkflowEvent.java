package org.example;

import org.example.collections.Nodes;
import org.example.wrappers.Node;

public abstract class WorkflowEvent extends Nodes {

	protected WorkflowEvent(String name){
		super(name);
	}
	
	@Override
	protected boolean acceptEmptyCollection() {
		return true;
	}
	
	@Override
	public int getIndentLevel() {
		for (Node tag : children) {
			tag.setIndentLevel(2);
		}
		return 1;
	}
}
