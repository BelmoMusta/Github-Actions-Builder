package org.example.collections;

import org.example.Appender;
import org.example.WorkflowEvent;
import org.example.wrappers.Indentable;
import org.example.wrappers.SingleElement;

import java.util.ArrayList;
import java.util.List;

public class Events extends Indentable {
	private final List<WorkflowEvent> innerEvents = new ArrayList<>();
	SingleElement on  = new SingleElement("on");
	
	public void add(WorkflowEvent event) {
		innerEvents.add(event);
	}
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		for (WorkflowEvent innerEvent : innerEvents) {
			innerEvent.setIndentLevel(getIndentLevel());
		}
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		appender.append(on);
		appender.append(innerEvents);
		return appender.toString();
	}
}
