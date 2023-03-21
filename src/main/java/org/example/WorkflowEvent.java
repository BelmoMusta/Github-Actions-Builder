package org.example;

import org.example.collections.AbstractCollection;
import org.example.wrappers.Indentable;

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
		for (Indentable tag : collection) {
			tag.setIndentLevel(2);
		}
		return 1;
	}
}
