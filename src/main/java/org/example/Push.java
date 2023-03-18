package org.example;

import org.example.collections.Branches;

public class Push extends WorkflowEvent {
	final Branches branches = new Branches();
	
	public static Push $() {
		return new Push();
	}
	
	public static Push branches(String... branches) {
		final Push push = new Push();
		for (String branch : branches) {
			Branch br = new Branch(branch);
			push.branches.add(br);
		}
		return push;
	}
	
	@Override
	public String toString() {
		branches.setIndentLevel(getIndentLevel() + 1);
		Appender appender = new Appender();
		appender.append("push: ");
		appender.newLine();
		if (!branches.isEmpty()) {
			appender.indent(getIndentLevel() + 1);
			appender.append("branches: ");
			appender.newLine();
			appender.append(branches.toString());
		}
		
		return appender.toString();
	}
}
