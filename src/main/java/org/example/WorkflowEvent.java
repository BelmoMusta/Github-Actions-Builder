package org.example;

import org.example.wrappers.Indentable;

import java.util.List;

public abstract class WorkflowEvent extends Indentable {
	protected abstract List<Indentable> getIndentables();
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		List<Indentable> indentables = getIndentables();
		appender.append(indentables);
		return appender.toString();
	}
}
