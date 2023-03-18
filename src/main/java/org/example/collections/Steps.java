package org.example.collections;

import org.example.Appender;
import org.example.wrappers.Indentable;
import org.example.Step;

import java.util.ArrayList;
import java.util.List;

public class Steps extends Indentable {
	final List<Step> steps = new ArrayList<>();
	
	public void add(Step step) {
		steps.add(step);
	}
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		for (Step step : steps) {
			step.setIndentLevel(getIndentLevel()+1);
		}
	}
	
	@Override
	public boolean isEmpty() {
		return steps.isEmpty();
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		if (!isEmpty()) {
			appender.indent(getIndentLevel());
			appender.append("steps:");
			appender.newLine();
			for (Step step : steps) {
				appender.append(step);
				appender.newLine();
			}
		}
		return appender.toString();
	}
}
