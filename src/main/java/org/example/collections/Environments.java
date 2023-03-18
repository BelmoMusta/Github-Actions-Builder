package org.example.collections;

import org.example.Appender;
import org.example.Environment;
import org.example.Indentable;
import org.example.WorkflowEvent;

import java.util.ArrayList;
import java.util.List;

public class Environments extends Indentable {
	private final List<Environment> envs = new ArrayList<>();
	
	public void add(Environment environment) {
		envs.add(environment);
	}
	
	@Override
	public String toString() {
		for (Environment env : envs) {
			env.setIndentLevel(getIndentLevel() + 1);
		}
		Appender appender = new Appender();
		appender.append("env: ");
		appender.newLine();
		for (Environment environment : envs) {
			appender.indent(getIndentLevel());
			appender.append(environment);
			appender.newLine();
		}
		
		return appender.toString();
	}
	
}
