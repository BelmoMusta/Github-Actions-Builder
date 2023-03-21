package org.example;

import org.example.collections.AbstractCollection;
import org.example.wrappers.Tag;

public abstract class WorkflowEvent extends AbstractCollection {

	protected WorkflowEvent(String name){
		super(name);
	}
	
	@Override
	protected boolean acceptEmptyCollection() {
		return true;
	}
	
	@Override
	public int getIndentLevel() {
		for (Tag tag : collection) {
			tag.setIndentLevel(2);
		}
		return 1;
	}
}
