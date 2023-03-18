package org.example.collections;

import org.example.Appender;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.Indentable;
import org.example.wrappers.SingleElement;

import java.util.ArrayList;
import java.util.List;

public class Options extends Indentable {
	SingleElement name = new SingleElement("options");
	private final List<DashSingleElement> options = new ArrayList<>();
	
	public void addAll(String... options) {
		for (String option : options) {
			DashSingleElement element = new DashSingleElement(option);
			this.options.add(element);
		}
	}
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		name.setIndentLevel(indentLvel);
		for (DashSingleElement option : options) {
			option.setIndentLevel(getIndentLevel() + 1);
		}
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		if (!options.isEmpty()) {
			appender.append(name);
			for (DashSingleElement option : options) {
				appender.append(option);
				appender.newLine();
			}
		}
		return appender.toString();
	}
	
	@Override
	public boolean isEmpty() {
		return options.isEmpty();
	}
}
