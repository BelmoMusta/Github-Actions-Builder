package org.example.collections;

import org.example.Appender;
import org.example.wrappers.Indentable;
import org.example.WorkflowEvent;

import java.util.ArrayList;
import java.util.List;

public class Events extends Indentable {
	private final List<WorkflowEvent> innerEvents = new ArrayList<>();
	
	public void add(WorkflowEvent event) {
		event.setIndentLevel(getIndentLevel() +1);
		innerEvents.add(event);
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		appender.append("on: ");
		appender.newLine();
		for (WorkflowEvent innerEvent : innerEvents) {
			appender.indent(getIndentLevel());
			appender.append(innerEvent);
		}
		
		return appender.toString();
	}
}
