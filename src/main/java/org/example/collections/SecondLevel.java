package org.example.collections;

import org.example.wrappers.Indentable;

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
		for (Indentable tag : collection) {
			tag.setIndentLevel(indentLevel + 1);
		}
	}
}
