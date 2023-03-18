package org.example;

import org.example.wrappers.DashSingleElement;
import org.example.wrappers.Indentable;

public class Branch extends Indentable {
	private DashSingleElement name;
	
	public Branch(String branch) {
		name = new DashSingleElement(branch);
	}
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		name.setIndentLevel(indentLvel);
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender()
				.append(name);
		return appender.toString();
	}
}
