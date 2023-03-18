package org.example;

import org.example.wrappers.Indentable;

public class Step extends Indentable {
	String name;
	String uses;
	String run;
	
	public static Step name(String name) {
		Step job = new Step();
		job.name = name;
		return job;
	}
	
	public Step uses(String s) {
		this.uses = s;
		return this;
	}
	public Step run(String s) {
		this.run = s;
		return this;
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		appender.indent(getIndentLevel());
		appender.append("- name: ").append(name);
		return appender.toString();
	}
}
