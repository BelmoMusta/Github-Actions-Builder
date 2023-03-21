package org.example.collections;

import org.example.wrappers.Tag;

public abstract class SecondLevel extends AbstractCollection {
	protected SecondLevel(String name) {
		super(name);
	}
	protected SecondLevel(String name, boolean nameWithDash) {
		super(name, nameWithDash);
	}
	@Override
	public void setIndentLevel(int indentLevel) {
		super.setIndentLevel(indentLevel);
		for (Tag tag : collection) {
			tag.setIndentLevel(indentLevel + 1);
		}
	}
}
