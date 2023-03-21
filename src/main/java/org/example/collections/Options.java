package org.example.collections;

import org.example.wrappers.DashQuotedSingleElement;
import org.example.wrappers.DashSingleElement;

public class Options extends SecondLevel {
	
	public Options() {
		super("options");
	}
	
	public void addAll(String... options) {
		for (String option : options) {
			DashSingleElement element = new DashQuotedSingleElement(option);
			super.add(element);
		}
	}
}
